package my.枚举;
/**
 * @author  : J
 * @version : 2017年6月13日  上午10:10:44
 * explain  : http://www.cnblogs.com/hyl8218/p/5088287.html
 */
public class Test_2 {
	public static void main(String[] args) {
		for(EnumTest e : EnumTest.values()){
			
			//  返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
//			System.out.println("ordinal(): "+e.ordinal());
			//  返回枚举常量的名称，它包含在声明中。
//			System.out.println("toString(): "+e.toString());
			// 返回与此枚举常量的枚举类型相对应的 Class 对象。
//			System.out.println( e.getDeclaringClass().getName());
		}
		
		
		EnumTest e1 = EnumTest.TUE;
		// 比较此枚举与指定对象的顺序。
		switch (e1.compareTo(EnumTest.MON)) {
        case -1:
            System.out.println("TUE 在 MON 之前");
            break;
        case 1:
            System.out.println("TUE 在 MON 之后");
            break;
        default:
            System.out.println("TUE 与 MON 在同一位置");
            break;
        }
		
	}
}

