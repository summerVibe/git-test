package my.RedisJava;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/** 
 * @author  J
 * @date 创建时间：Jan 4, 2018 - 10:57:39 AM
 * @version 1.0 
 */
public class Test1 {
	
//	@Test
	public  void main() {
		//连接 Redis 服务
		Jedis jedis = new Jedis("192.168.100.168");
		System.out.println("连接成功");
		//设置 redis 字符串数据
		jedis.set("redis", "hello world");
		// 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("s"));
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
	}
	
}
