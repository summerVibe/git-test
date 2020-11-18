package my.时间日期;

public class Weekend {
    public static void main(String[] args) {
        Integer i1 = 123;
        Integer i2 = 123;

        Integer i3 = new Integer(123);
        Integer i4 = new Integer(123);

        Integer i5 = 129;
        Integer i6 = 129;

        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i1 == i4);
        System.out.println(i5 == i6);
    }

}
