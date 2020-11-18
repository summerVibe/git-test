package my.随机码;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNum {


    public static String genRandomNum(){
        int  maxNum = 36;
        int i;
        int count = 0;
//        char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
//                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
//                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count < 9){
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }
        return pwd.toString();
    }

    public static void main(String[] args) {
        System.out.println(genRandomNum());
//        String s = null;
//        List<String> slist = new ArrayList<>();
//        List<String> slist2 = new ArrayList<>();
//        for (int i = 0;i < 1000000;i++) {
//            s = genRandomNum();
//            slist.add(s);
//        }
//        for (String s1:slist) {
//            if (!slist2.contains(s1)){
//                slist2.add(s1);
//            }
//        }
//        System.out.println("slist.size() ------"+slist.size());
    }



}
