package my.test;

public class test_1 {
	public static void main(String[] args) {
		say();
		System.out.println(say().getName());
	}
public static Student say(){
	Student s =new Student();
	s.setAge(1);
	s.setName("张三");
	return s;
	}

}
