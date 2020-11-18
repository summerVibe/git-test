package my.constructor;

class One {
	One(String str) {
		System.out.println(str);
	}
}

class Two {
	One one_1 = new One("one-1");
	One one_2 = new One("one-2");
	static One one_3 = new One("one-3");

	Two(String str) {
		System.out.println(str);
	}
}

public class Test {

	static Two two_3 = new Two("two-3");

	public static void main(String[] args) {
		System.out.println("Test main() start");
		Two two_1 = new Two("two-1");
		System.out.println("------------");
		Two two_2 = new Two("two-2");
	}
}