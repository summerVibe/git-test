package my.test;
/**
 * @author  : J
 * @version : 2017年5月17日  上午10:25:17
 * explain  : 
 */
public class Mastiff extends Dog{
	 public Mastiff() {  
	        System.out.println("Mastiff");  
	    }  
	  
	    {  
	        System.out.println("block");  
	    }  
	    static {  
	        System.out.println("static block");  
	    }  
	      
	    public static void  main(String[] args){  
	        Mastiff mastiff=new Mastiff();  
	          
	    }  
}
