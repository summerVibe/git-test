package chitule.test;

import chitule.vo.Vo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException{
        for (int i = 1;i < 2461;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }

    @org.junit.Test
    public void test1()throws Exception{
        for (int i = 1;i <= 500;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }

    @org.junit.Test
    public void test2()throws Exception{
        for (int i = 501;i <= 1000;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }

    @org.junit.Test
    public void test3()throws Exception{
        for (int i = 1001;i <= 1500;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }
    @org.junit.Test
    public void test4()throws Exception{
        for (int i = 1501;i <= 2000;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }

    @org.junit.Test
    public void test5()throws Exception{
        for (int i = 2001;i <= 2500;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }


    public static void queryJSList(String pageNo) throws IOException{
        String url = "http://218.7.20.72:8080/hdHljnjdd/njdz/queryJSList";
        Map msp = new HashedMap();
        msp.put("pageNo",pageNo);
        String s = post(url,msp);
        JSONObject jsonObject = JSON.parseObject(s);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray list = data.getJSONArray("list");
        if (list != null && list.size() != 0){
            List<Vo> list1 = JSONArray.parseArray(list.toJSONString(), Vo.class);
            for (Vo vo : list1) {
                if (StringUtils.isBlank(vo.getOwnerPhone()) || vo.getOwnerPhone().length() != 11) continue;
                System.out.println(
                        "用户名：" + vo.getOwnerName()
                                + "  电话号码：" + vo.getOwnerPhone()
                                + "  作业类型：" + getWorkTypeName(vo.getWorkType())
                                + "  地址：" +  vo.getShideptName() + vo.getXiandeptName() + vo.getMachineAddress()
                                + "  作业时段：" + getdate(vo.getBeginDate()) + " - " + getdate(vo.getEndDate())
                                + ""
                );
            }
        }
    }


    public static String getdate(String dateStr) {
        String s = null;
        try {
            s = getDateByDateStr(dateStr,"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getDateByDateStr(String dateStr,String format1,String forma2) throws Exception{
        SimpleDateFormat sformat = new SimpleDateFormat(format1);
        Date date = sformat.parse(dateStr);
        SimpleDateFormat sformat2 = new SimpleDateFormat(forma2);
        return sformat2.format(date);
    }

    public static String getWorkTypeName(String workType){
        String workTypeName = "-";
        if("1".equals(workType)){
            workTypeName = "春季联合整地";
        }else if("2".equals(workType)){
            workTypeName = "秋季联合整地";
        }else if("3".equals(workType)){
            workTypeName = "深松作业";
        }else if("4".equals(workType)){
            workTypeName = "播种作业";
        }else if("5".equals(workType)){
            workTypeName = "田间管理";
        }else if("6".equals(workType)){
            workTypeName = "旋耕作业";
        }else if("7".equals(workType)){
            workTypeName = "收获作业";
        }else if("8".equals(workType)){
            workTypeName = "植保作业";
        }else if("9".equals(workType)){
            workTypeName = "秸秆还田";
        }
        return workTypeName;
    }

    public static String post(String urlStr, Map<String, String> parameterMap) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // 设置该连接是可以输出的
        httpURLConnection.setRequestMethod("POST"); // 设置请求方式
        httpURLConnection.setRequestProperty("charset", "utf-8");

//        System.out.println(httpURLConnection.getURL().toString());

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));

        StringBuffer parameter = new StringBuffer();
        parameter.append("1=1");
        for (Map.Entry<String, String> entry : parameterMap.entrySet())
        {
            parameter.append("&" + entry.getKey() + "=" + entry.getValue());
        }
        pw.write(parameter.toString());// 向连接中写数据（相当于发送数据给服务器）

        pw.flush();
        pw.close();

//        System.out.println("parameter: " + parameter.toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null)
        { // 读取数据
            sb.append(line + "\n");
        }
        br.close();
//        System.out.println(sb.toString());
        return sb.toString();
    }

}
