package my.test;
/**
 * @author  : J
 * @version : May 4, 2017  4:31:16 PM
 * explain  : 
 */
public class A {

	B b = new B("AB");
	static {
		System.out.println("A_static");
	}

	public A() {
		System.out.println("A");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C();
	}

}

class B {
	static {
		System.out.println("B_static");
	}

	public B(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		System.out.println("B_main");
	}
}

class C extends A {

	static {
		System.out.println("C_static");
	}

	public C() {
		System.out.println("cKKKK");
	}

	public static void main(String[] args) {
		B b = new B("CB");

	}
}