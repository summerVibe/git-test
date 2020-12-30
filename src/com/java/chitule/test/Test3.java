package chitule.test;

import chitule.vo.Vo4;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.List;

// 大丰收 - 收割机
public class Test3 {



    /**
     * 发送 get请求
     */
    public static String getHttp(String httpUrl) {
        String outStr = "";
        if (httpUrl == null || httpUrl.equals("")|| !httpUrl.startsWith("http")) {
            return outStr;
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(httpUrl);
            //设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpget.setConfig(requestConfig);
            httpget.setHeader("token","2E7nr5WQuvH5SG71C2qDtXHSYncdzucMuZ6NYpOuqT2AIFuYmbg71GXsnethOtFoZoTLnsBR96IpuROnRkESTYLT6a7tKBFgBBwRp8Z5n61Be6WEwC4=");
            httpget.setHeader("app_version","1.9.1");
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 响应状态
                int httpStatusCode = response.getStatusLine().getStatusCode();
                if(httpStatusCode != HttpStatus.SC_OK){
                    return outStr;
                }
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // 响应内容
                    byte[] result = EntityUtils.toByteArray(entity);
                    outStr = new String(result);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return outStr;
    }


    public static void queryJSList(String pageNo,BufferedWriter bw) throws IOException{
        // https://wx.03968.cn/harvester_test/api/driver/list?ltype=new&p=1
        String url = "https://wx.03968.cn/harvester_test/api/driver/list?ltype=new&p="+pageNo;
        try {
            String s = getHttp(url);
//            System.out.println(s);

            JSONObject jsonObject = JSON.parseObject(s);
            JSONArray list = jsonObject.getJSONArray("list");
            if (list != null && list.size() != 0){
                List<Vo4> list1 = JSONArray.parseArray(list.toJSONString(), Vo4.class);
//                FileWriter out=new FileWriter ("C:\\Users\\jack\\Desktop\\text4.txt");
//                BufferedWriter bw= new BufferedWriter(out);
                for (Vo4 vo : list1) {
                    if ("已绑定手机".equals(vo.getMobile_bind_status_desc())){
                        String url2 = "https://wx.03968.cn/harvester_test/api/driver/mobile/"+vo.getSchedule_id()+"?action=phone&pay_state=notpay";
                        String ss = getHttp(url2);
                        Thread.sleep(1000);
                        JSONObject j = JSON.parseObject(ss);
                        String phone = j.getString("mobile");
                        String str = "用户名：" + vo.getCallname()
                                + "  电话号码：" + phone
                                + "  收割机类型：" + vo.getMachine_type()
                                + "  作业地区：" + vo.getDestination();
                        StringBuilder sb = new StringBuilder("");
                        int i = 25;
                        sb.append(appentStr4Length("用户名：" + vo.getCallname(),i));
                        sb.append(appentStr4Length("电话号码：" + phone,i));
                        sb.append(appentStr4Length("收割机类型：" + vo.getMachine_type(),35));
                        sb.append(appentStr4Length("作业地区：" + vo.getDestination(),i));
                        bw.write(sb.toString());
                        bw.newLine();
                    }
                }
//                bw.flush();
//                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void write(String str) throws Exception{
        // 文件写入操作
        FileOutputStream outputStream = null;
        try {
            File file = new File("C:\\Users\\jack\\Desktop\\text4.txt");
            file.createNewFile();//创建文件
            outputStream = new FileOutputStream(file,true);//形参里面可追加true参数，表示在原有文件末尾追加信息
            outputStream.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String appentStr4Length(String str , int length){
        if(str == null){
            str = "";
        }
        try {
            int strLen = 0;//计算原字符串所占长度,规定中文占两个,其他占一个
            for(int i = 0 ; i<str.length(); i++){
                if(isChinese(str.charAt(i))){
                    strLen = strLen + 2;
                }else{
                    strLen = strLen + 1;
                }
            }
            if(strLen>=length){
                return str;
            }
            int remain = length - strLen;//计算所需补充空格长度
            for(int i =0 ; i< remain ;i++){
                str = str + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        FileWriter out= null;
        BufferedWriter bw= null;
        try {
            out=new FileWriter ("C:\\Users\\jack\\Desktop\\text4.txt");
            bw= new BufferedWriter(out);
            for (int i = 1;i <= 100;i++){
                System.out.println("第"+i+"页");
                queryJSList(i+"",bw);
            }
        }catch (Exception e){

        }finally {
            bw.flush();
            bw.close();
        }
    }

    @org.junit.Test
    public void test1()throws Exception{
        FileWriter out= null;
        BufferedWriter bw= null;
        try {
            out=new FileWriter ("C:\\Users\\jack\\Desktop\\text1.txt");
            bw= new BufferedWriter(out);
            for (int i = 1;i <= 100;i++){
                System.out.println("第"+i+"页");
                queryJSList(i+"",bw);
            }
        }catch (Exception e){

        }finally {
            bw.flush();
            bw.close();
        }
    }

    @org.junit.Test
    public void test2()throws Exception{
        FileWriter out= null;
        BufferedWriter bw= null;
        try {
            out=new FileWriter ("C:\\Users\\jack\\Desktop\\text2.txt");
            bw= new BufferedWriter(out);
            for (int i = 101;i <= 200;i++){
                System.out.println("第"+i+"页");
                queryJSList(i+"",bw);
            }
        }catch (Exception e){

        }finally {
            bw.flush();
            bw.close();
        }
    }

    @org.junit.Test
    public void test3()throws Exception{
        FileWriter out= null;
        BufferedWriter bw= null;
        try {
            out=new FileWriter ("C:\\Users\\jack\\Desktop\\text3.txt");
            bw= new BufferedWriter(out);
            for (int i = 201;i <= 300;i++){
                System.out.println("第"+i+"页");
                queryJSList(i+"",bw);
            }
        }catch (Exception e){

        }finally {
            bw.flush();
            bw.close();
        }
    }


}
