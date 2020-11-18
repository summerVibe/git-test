package my.constructor;

/**
 * http://www.blogjava.net/weidagang2046/articles/3430.html
 * 2017-2-4
 * 构造器中this的使用：
 * 	1.构造器和方法使用关键字this有很大的区别。方法引用this指向正在执行方法的类的实例。静态方法不能使用this关键字，
 * 因为静态方法不属于类的实例，所以this也就没有什么东西去指向。
 * 	2.构造器的this指向同一个类中，不同参数列表的另外一个构造器,构造方法中只能通过this调用一次其他的构造方法。。
 * 在构造器中，如果要使用关键字this,那么，必须放在第一行，如果不这样，将导致一个编译错误。 
 * 
 * 在下面的代码中，有2个不同参数列表的构造器。第一个构造器，给类的成员name赋值，
 * 第二个构造器，调用第一个构造器，给成员变量name一个初始值 "John/Mary Doe". 
 *
 *	2017-4-17 ：好文章：http://www.2cto.com/kf/201311/255432.html
 *
 *
 */
public class Constructor_01 {

	String name;
	String code;
	
	Constructor_01(String input) {
		name = input+"aa";
	}

	Constructor_01() {
		this("John/Mary Doe");
	}
	
	public static void main(String args[]) {
		Constructor_01 p1 = new Constructor_01("digger");
		System.out.println("p1  "+p1.name);
		
		Constructor_01 p2 = new Constructor_01();
		System.out.println("p2  "+p2.name);
	}
}
