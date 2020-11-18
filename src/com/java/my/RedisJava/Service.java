package my.RedisJava;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/** 
 * @author  J
 * @date 创建时间：Jan 16, 2018 - 10:59:57 AM
 * @version 1.0 
 */
public class Service {
	
	private static JedisPool pool = null;
	
	int n = 500;
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大连接数
		config.setMaxTotal(200);
		// 最大空闲数
		config.setMaxIdle(8);
		// 最大等待时间
		config.setMaxWaitMillis(1000 * 100);
		// 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
		config.setTestOnBorrow(true);
//		pool = new JedisPool("192.168.100.168");
		pool = new JedisPool(config,"192.168.100.168",6379,3000);
	}
	DistributedLock lock = new DistributedLock(pool);
	
	
	
	public void seckill(){
		// 返回锁的value值，供释放锁时进行判断
//		String identifier = lock.lockWithTimeout("resource", 5000, 1000);
		System.out.println(Thread.currentThread().getName() + " 获得了锁");
		System.out.println(--n);
//		lock.releaseLock("resource", identifier);
	}
	
	
	
	
	
}
