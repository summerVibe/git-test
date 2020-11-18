package project.park;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class HttpUtil {

    /**
     * 发送 post请求
     */
    public static String postFormData(String httpUrl, Map<String, String> inPara) {
        String result = "";

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(httpUrl);
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(8000).setConnectTimeout(8000).build();
        httppost.setConfig(requestConfig);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        if(inPara!=null&&!inPara.isEmpty()){
            Iterator<String> it = inPara.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = inPara.get(key);
                formparams.add(new BasicNameValuePair(key, value));
            }
        }
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("-------------"+httppost.toString());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(response.getEntity(),"UTF-8");
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
            }
        }
        return result;
    }



    /**
     * 发送 post请求
     */
    public static String postFormData2(String httpUrl, JSONObject jsonObject) {
        String result = "";

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(httpUrl);
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(8000).setConnectTimeout(8000).build();
        httppost.setConfig(requestConfig);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        if(jsonObject != null && !jsonObject.isEmpty()){
            Iterator<String> it = jsonObject.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = jsonObject.getString(key);
                formparams.add(new BasicNameValuePair(key, value));
            }
        }
        for (NameValuePair nameValuePair:formparams) {
            System.out.println(">>>>>>>>>>>>>>> nameValuePair :"+nameValuePair.getName()+"="+nameValuePair.getValue());
        }
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("-------------"+httppost.toString());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(response.getEntity(),"UTF-8");
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
            }
        }
        return result;
    }

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



    public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

//        json方式
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("carno", "川QFB316");
        System.out.println("     jsonParam.toString  "+jsonParam.toString());
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

//        表单方式
//        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
//        pairList.add(new BasicNameValuePair("name", "admin"));
//        pairList.add(new BasicNameValuePair("pass", "123456"));
//        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));


        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }


    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        System.out.println("text + key  "+text + key);
        String encodeStr= DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }


    public static void main(String[] args) {
        /*String url = "http://parkapi.newmlife.com/partnerservice/getprostop?partnerid=test&sign=";
        String key = "206d98f4de9e4423b3aa42cd0c36fd84";

        JSONObject jsonParam = new JSONObject();
        // 川QFB316   川A11111
        jsonParam.put("carno", "川QFB316");
        String str = jsonParam.toJSONString() + key;
        System.out.println(">>>>>>>>>>.str   "+str);
        try {
            String sign = md5(jsonParam.toJSONString(),key);
            String result2 = httpPostWithJSON(url+sign);
            System.out.println(result2);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


//        doQueryProstop();

        String url = "http://parkapi.newmlife.com/partnerservice/getprostop";
        String key = "206d98f4de9e4423b3aa42cd0c36fd84";
        String partnerid = "test";
//        String key = "16192d4ca0004237bd83d8ea625fda36";
//        String partnerid = "newmlife";

        // 川QFB316   川A11111
        String carno = "川QFB3161";

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("carno",carno);
        try {
            String sign = md5(jsonParam.toJSONString(),key);
            url += "?partnerid="+partnerid+"&sign="+sign;
            String result = httpPostWithJSONV2(url,jsonParam);
            System.out.println(">>>>>>>>>>>>>>> result: "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String doQueryProstop(){
        String url = "http://parkapi.newmlife.com/partnerservice/getprostop";
        String key = "206d98f4de9e4423b3aa42cd0c36fd84";
        String partnerid = "test";
//        String key = "16192d4ca0004237bd83d8ea625fda36";
//        String partnerid = "newmlife";

        // 川QFB316   川A11111
        String carno = "川QFB316";

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("carno",carno);
        try {
            String sign = md5(jsonParam.toJSONString(),key);
            url += "?partnerid="+partnerid+"&sign="+sign;

        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<>();
        System.out.println(">>>>>>>>>>>>>>> url: "+url);
        String result = postFormData2(url,jsonParam);
        System.out.println(">>>>>>>>>>>>>>> result: "+result);
        return result;
    }

    public static String httpPostWithJSONV2(String url,JSONObject jsonParam) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        System.out.println("     httpPostWithJSONV2  jsonParam.toString  "+jsonParam.toString());
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }
}
