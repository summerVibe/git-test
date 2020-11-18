package my.时间日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Week {

    public static void main(String[] args) {

        String today = "2010-01-03";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
//        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));

        getMondayOfYearWeek(2017,36);
        getSundayOfYearWeek(2017,36);

    }



// https://blog.csdn.net/a2229833/article/details/78484397
    public static int getWeekOfYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        System.out.println("-----------------"+calendar.get(Calendar.WEEK_OF_YEAR));
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }


    public static void getWeekDate(int weekYear,int weekOfYear){
        Calendar calendar = Calendar.getInstance();

        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天
        calendar.setMinimalDaysInFirstWeek(4);//可以不用设置
        calendar.setTimeInMillis(System.currentTimeMillis());//获得当前的时间戳
//        int weekYear = calendar.get(Calendar.YEAR);//获得当前的年
//        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);//获得当前日期属于今年的第几周
//
        System.out.println("第几周："+weekOfYear);

        calendar.setWeekDate(weekYear, weekOfYear, 2);//获得指定年的第几周的开始日期
        long starttime = calendar.getTime().getTime();//创建日期的时间该周的第一天，
        calendar.setWeekDate(weekYear, weekOfYear, 1);//获得指定年的第几周的结束日期
        long endtime = calendar.getTime().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStart = simpleDateFormat.format(starttime);//将时间戳格式化为指定格式
        String dateEnd = simpleDateFormat.format(endtime);
        System.out.println("开始时间   "+dateStart);
        System.out.println("结束时间   "+dateEnd);
    }


    // 获取某年某周的星期一的时间
    public static String getMondayOfYearWeek(int year,int weekNum){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天

        calendar.setWeekDate(year, weekNum, 2);//获得指定年的第几周的开始日期
        long starttime = calendar.getTime().getTime();//创建日期的时间该周的第一天，

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStart = simpleDateFormat.format(starttime);//将时间戳格式化为指定格式
        System.out.println("星期一：   "+dateStart+" 00:00:00");


        return dateStart;

    }

    // 获取某年某周的星期日的时间
    public static String getSundayOfYearWeek(int year,int weekNum){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周开始的第一天
        calendar.setWeekDate(year, weekNum, 1);//获得指定年的第几周的结束日期
        long endtime = calendar.getTime().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateEnd = simpleDateFormat.format(endtime);
        System.out.println("星期日 ： "+dateEnd+" 23:59:59");
        return dateEnd;

    }





}
