package my.test;
/**
 * @author  : J
 * @version : 2017年6月27日  上午9:39:22
 * explain  : 
 */
public class Example {
	String str = new String("good");

    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {

        Example ex = new Example();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.print(ex.ch);

    }

    public void change(String str, char ch[]) {

        str = "test ok";

        ch[0] = 'g';


    }
}
