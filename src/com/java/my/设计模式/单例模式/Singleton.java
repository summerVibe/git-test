package my.设计模式.单例模式;
/**
 * @author  : J
 * @version : Jul 25, 2017  3:38:40 PM
 * explain  : 
 */

/**
 * 区别：
 * 饿汉模式的特点是加载类时比较慢，但是运行时获取对象的速度比较快     线程安全
 * 懒汉模式加载类时相对快，运行时获取对象的速度比较慢   线程不安全
 */



/**
 * 懒汉 ----效率低
 * 调用时创建
 */
public class Singleton {
	// 将构造方法私有化，不允许外部直接创建对象
	private Singleton(){};
	
	// 声明类的唯一实例  使用private static
	private static Singleton singleton;
	
	// 提供一个用于获取实例的方法
	public static /*synchronized*/ Singleton getSingleton(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
}

/**
 * 饿汉
 * 类加载时创建
 */
class Singleton_2 {
	// 将构造方法私有化，不允许外部直接创建对象
	private Singleton_2(){};
	// 创建类的唯一实例 使用private static
	private static Singleton_2 singleton = new Singleton_2();
	// 提供一个用于获取实例的方法
	public static Singleton_2 getInstance() {  
	    return singleton;  
	}  
}


