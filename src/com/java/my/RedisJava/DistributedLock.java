package my.RedisJava;

import java.util.List;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

/** redis分布式锁
 * @author  J
 * @date 创建时间：Jan 16, 2018 - 9:34:24 AM
 * @version 1.0 
 */
public class DistributedLock {
	private final JedisPool jedisPool;
	
	public DistributedLock(JedisPool jedisPool){
		this.jedisPool = jedisPool;
	}
	
	/**
	 * 加锁
	 * @param lockName			锁的key
	 * @param acquireTimeout	获取超时时间
	 * @param timeout			锁的超时时间
	 * @return	锁标识
	 */
	public String lockWithTimeout(String lockName,long acquireTimeout,long timeout){
		
		Jedis conn = null;
		String retIdentifier = null;
		
		try {
			// 获取连接
			conn = jedisPool.getResource();
			// 随机生成value
			String identifier = UUID.randomUUID().toString();
			// 锁名，key值
			String lockKey = "lock:" + lockName;
			// 超时时间，上锁后超过此时间自动释放锁
			int  lockExpore = (int) (timeout / 1000);
			
			// 获取锁的超时时间。超过这个时间则放弃获取锁
			long end = System.currentTimeMillis() + acquireTimeout;
			while (System.currentTimeMillis() < end){
				if(conn.setnx(lockKey, identifier) == 1){
					conn.expire(lockKey, lockExpore);
					retIdentifier = identifier;
					return retIdentifier;
				}
				
				// 返回-1代表可以没有设置超时时间，为key设置一个超时时间
				if(conn.ttl(lockKey) == -1){
					conn.expire(lockKey, lockExpore);
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		return retIdentifier;
		
	}
	
	/**
	 * 释放锁
	 * @param lockName		锁的key
	 * @param identifier	释放锁的标识
	 * @return
	 */
	public boolean releaseLock(String lockName,String identifier){
		
		Jedis conn = null;
		String lockKey = "lock:"+lockName;
		boolean retFlag = false;
		
		try {
			conn = jedisPool.getResource();
			
			while(true){
				// 监视lock，准备开始事物
				conn.watch(lockKey);
				// 通过返回的value值判断是不是该锁，若是，则删除，释放锁
				if(identifier.equals(conn.get(lockKey))){
					Transaction tr = conn.multi();
					tr.del(lockKey);
					List<Object> results = tr.exec();
					if(results == null ){
						continue;
					}
					retFlag = true;
				}
				conn.unwatch();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		return retFlag;
	}
	
	
	

}
