package my.导入导出;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.zxing.common.StringUtils;
import net.sf.json.JSON;
import org.apache.poi.util.StringUtil;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportTest {

    @Test
    public void test1(){
        String filePath = "C:\\Users\\E465\\Desktop\\ImportTest.xlsx";
        InputStream is = getInputStream(filePath);
        List<Object> objectList = read(is);
        List<Model> modelList = buildModelList(objectList);
        // 验证数据是否正确
        Boolean flag = validate(modelList);
        if (!flag){
            writeByModel(modelList);
        }
    }


    public void writeByModel(List<? extends BaseRowModel> data){
        OutputStream out=null;
        try {
            out = new FileOutputStream(new File("C:\\Users\\E465\\Desktop\\ImportTest2.xlsx"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0,Model.class);
//            sheet1.setSheetName("");
            writer.write(data, sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void writeWithoutHead(InputStream inputStream,List<Model> modelList) throws IOException{
        OutputStream out = new FileOutputStream("C:\\Users\\E465\\Desktop\\ImportTest2.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriterWithTemp(inputStream,out, ExcelTypeEnum.XLSX,true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 2);
        sheet1.setStartRow(0);
        List<List<String>> data = new ArrayList<>();
        List<String> test1 = new ArrayList<>();
        test1.add("123");
        test1.add("1234");
        test1.add("住宅");
        test1.add("福建省");
        test1.add("厦门市");
        test1.add("海沧区");
        data.add(test1);
        writer.write0(data, sheet1);
        writer.finish();
    }

    private Boolean validate(List<Model> modelList){
        Boolean flag = true;
        Map<String,String> validateMap = new HashMap<>();
        if (modelList != null && modelList.size() >0){
            for (Model model : modelList) {
                String ageValidateMsg = validateAge(model.getAge());
                String sexValidateMsg = validateSex(model.getSex());
                if (!"".equals(ageValidateMsg)) validateMap.put("年龄",ageValidateMsg);
                if (!"".equals(sexValidateMsg)) validateMap.put("性别",sexValidateMsg);
                model.setValidateMap(validateMap);
                model.setMsg(buildMsg(validateMap));
                if (validateMap.size() > 0) flag = false;
            }
        }
        return flag;
    }

    public String buildMsg(Map<String,String> validateMap){
        StringBuffer msg = new StringBuffer("");
        if (validateMap.size() > 0){
            for(String key : validateMap.keySet()){
                String value = validateMap.get(key);
                msg.append(key +": "+value+"  "+"\r\n");
            }
        }
        return msg.toString();
    }


    private String validateAge(String ageStr){
        String msg = "";
        int age = ageStr != null ? Integer.valueOf(ageStr) : 0;
        if (age > 20){
            msg = "年龄大于等于20岁";
        }
        return msg;
    }

    private String validateSex(String sex){
        String msg = "";
        if (!"男".equals(sex)){
            msg = "只能为男性";
        }
        return msg;
    }


    private List<Model> buildModelList(List<Object> objectList){
        List<Model> modelList = new ArrayList<>();
        if (objectList != null && objectList.size() >0){
            for (Object object : objectList) {
                modelList.add((Model) object);
            }
        }
        return modelList;
    }

    private InputStream getInputStream(String filePath){
        InputStream is = new ByteArrayInputStream(File2byte(filePath));
        return is;
    }

    public List<Object> read(InputStream is){
        List<Object> objectList = null;
        try {
            objectList =  EasyExcelFactory.read(is,new Sheet(1,1, Model.class));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return objectList;
    }

    public static byte[] File2byte(String filePath)
    {
        byte[] buffer = null;
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer;
    }



}
