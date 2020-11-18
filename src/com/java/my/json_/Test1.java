package my.json_;

        import com.alibaba.fastjson.JSON;
        import com.alibaba.fastjson.JSONArray;
        import com.alibaba.fastjson.JSONObject;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.codehaus.jackson.JsonParser;

        import java.io.IOException;
        import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        String jsonString2 = "{\"Records\":[{\"ID\":1543318566,\"PropID\":110,\"PropNum\":1,\"CostPropID\":2,\"CostPropNum\":5500,\"ExchangeTime\":1543318566,\"Status\":1,\"DeliverInfo\":\"{\"phone\":\"15228956236\",\"receiver\":\"鐐哥殑\",\"address\":\"鎴愰兘甯俓\"}\",\"ChannelID\":100},{\"ID\":1543318584,\"PropID\":119,\"PropNum\":1,\"CostPropID\":2,\"CostPropNum\":11000,\"ExchangeTime\":1543318584,\"Status\":1,\"DeliverInfo\":\"{\"phone\":\"15228956236\",\"receiver\":\"鐐哥殑\",\"address\":\"鎴愰兘甯俓\"}\",\"ChannelID\":100}]}";

        String s = jsonString(jsonString2);
        System.out.println(" "+s);
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(s);
        System.out.println("--------------"+jsonObject.get("Records"));

        JSONArray ja = JSONArray.parseArray(jsonObject.get("Records").toString());
        JSONObject j = (JSONObject)ja.get(0);
        System.out.println("--------------"+j.get("ID"));

//        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(jsonString2);

    }

    private static String jsonString(String s){
        char[] temp = s.toCharArray();
        int n = temp.length;
        for(int i =0;i<n;i++){
            if(temp[i]==':'&&temp[i+1]=='"'){
                if(temp[i+2]=='{' ){
                    temp[i+1]=' ';
                }
            }
            if(i >= 1 && temp[i-1]=='}'&&temp[i]=='"'){
                temp[i]=' ';
            }
        }
        return new String(temp);
    }




}
