package my.file_.readTxt;

import java.io.*;

import org.apache.cxf.helpers.FileUtils;



public class Read_file {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\E465\\Desktop\\1234\\1.txt";
//        String filePath = "C:\\Users\\E465\\Desktop\\1234\\2.txt";
//        String filePath = "C:\\Users\\E465\\Desktop\\1234\\3.txt";
//        String filePath = "C:\\Users\\E465\\Desktop\\1234\\4.txt";


//        String c = readTxt(filePath);
//        System.out.println("c:   "+c);

        /*File file = new File(filePath);
        String code = resolveCode(filePath);// 编码格式
        String content = FileUtils.readFileToString(file,code);
        String newContent = convertEncodingFormat(content,code,"UTF-8");
        System.out.println("content:    "+content);
        System.out.println("newContent:    "+newContent);*/

//        readTxt2(filePath);
    }




    public static void readTxt2(String filePath) {

        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    System.out.println(lineTxt);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }

    }



    public static String convertEncodingFormat(String str, String formatFrom, String FormatTo) {
        String result = null;
        if (!(str == null || str.length() == 0)) {
            try {
                result = new String(str.getBytes(formatFrom), FormatTo);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }





    /**
     * 解析普通文本文件  流式文件 如txt
     * @param path
     * @return
     */
    @SuppressWarnings("unused")
    public static String readTxt(String path){
        StringBuilder content = new StringBuilder("");
        try {
            String code = resolveCode(path);
            File file = new File(path);
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is, code);
            BufferedReader br = new BufferedReader(isr);
//          char[] buf = new char[1024];
//          int i = br.read(buf);
//          String s= new String(buf);
//          System.out.println(s);
            String str = "";
            while (null != (str = br.readLine())) {
                content.append(str);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("读取文件:" + path + "失败!");
        }
        return content.toString();
    }



    public static String resolveCode(String path) throws Exception {
        InputStream inputStream = new FileInputStream(path);
        byte[] head = new byte[3];
        inputStream.read(head);
        String code = "GB2312";  //或GBK
        if (head[0] == -1 && head[1] == -2 )
            code = "UTF-16";
        else if (head[0] == -2 && head[1] == -1 )
            code = "Unicode";
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
            code = "UTF-8";

        inputStream.close();

        System.out.println(code);
        return code;
    }

}