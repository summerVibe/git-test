package chitule.test;

import chitule.vo.Vo1;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.HashedMap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Test1 {

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

    public static void queryJSList(String pageNo) throws IOException {
        String url = "http://njzy.njztc.com/njzy_driver_ajax.jspx";
        Map msp = new HashedMap();
        msp.put("pageNo",pageNo);
        msp.put("pageSize","1000");
        msp.put("roleCode","62");
        msp.put("pageNo",pageNo);
        String s = post(url,msp);
        JSONObject jsonObject = JSON.parseObject(s);
        JSONArray list = jsonObject.getJSONArray("root");
        if (list != null && list.size() != 0){
            List<Vo1> list1 = JSONArray.parseArray(list.toJSONString(), Vo1.class);
            for (Vo1 vo : list1) {
                System.out.println(
                        "用户名：" + vo.getName()
                        + "  电话号码：" + vo.getPhone()
                        + "  地址：" + vo.getAddress()
                );
            }
        }
    }


    @org.junit.Test
    public void test1()throws Exception{
        for (int i = 1;i <= 4;i++){
            System.out.println("第"+i+"页");
            queryJSList(i+"");
        }
    }


}
