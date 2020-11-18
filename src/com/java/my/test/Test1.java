package my.test;
/**
 * @author  : J
 * @version : Aper 18, 2017  7:45:38 PM
 * explain  : 
 */

public class Test1 {
	public static int i=0;  
    public static int X=100;  
    public final static int Y=200;
    public Test1(){  
        System.out.println("Test构造函数执行");  
    }  
    static{  
        System.out.println("static语句块执行");  
    }  
    
    {
        System.out.println("not static 语句块执行");
    }
    
    public static void display(){  
        System.out.println("静态方法被执行");  
    }  
    public void display_1(){  
        System.out.println("实例方法被执行");  
    }  
    
    public static void main(String [] args){
        Test1.display();
        System.out.println("x=" + Test1.X + "   y=" + Test1.Y );
        Test1.display();
        Test1 t1 = new Test1();
        Test1 t2 = new Test1();
        System.out.println("X=" + t1.X + "   Y=" + t1.Y);
        Test1.display();
    }
}
