package my.图片;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

// https://www.cnblogs.com/azhqiang/p/7677844.html
public class ChartGraphics {
    private BufferedImage image;
    private int imageWidth = 300;  //图片的宽度
    private int imageHeight = 500; //图片的高度
    //生成图片文件
    @SuppressWarnings("restriction")
    public void createImage(String fileLocation) {
        BufferedOutputStream bos = null;
        if(image != null){
            try {
                FileOutputStream fos = new FileOutputStream(fileLocation);
                bos = new BufferedOutputStream(fos);

                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
                encoder.encode(image);
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(bos!=null){//关闭输出流
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void graphicsGeneration(String name, String id, String classname, String imgurl) {
        int H_title = 30;     //头部高度

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
//        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);

        //设置字体
        Font titleFont = new Font("宋体", Font.PLAIN, 16);
        Font titleFont1 = new Font("宋体", Font.PLAIN, 14);
        Font titleFont2 = new Font("宋体", Font.PLAIN, 12);

        //***********************页面头部
        Graphics title = image.createGraphics();
        //设置区域颜色
        title.setColor(new Color(248,248,255));
        //填充区域并确定区域大小位置
//        title.fillRect(0, 0, imageWidth, H_title);
        //设置字体颜色，先设置颜色，再填充内容
        title.setColor(Color.black);
        title.setFont(titleFont);
        title.drawString("漫生活通行码", getWidth("漫生活通行码",16), (H_title)/2+5);

        //***********************项目信息
        Graphics projectNameTitle = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        projectNameTitle.setColor(Color.black);
        projectNameTitle.setFont(titleFont1);
        projectNameTitle.drawString("漫生活体验社区", getWidth("漫生活体验社区",14), H_title+20);

        //***********************访客姓名性别信息
        Graphics UserNameTitle = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        UserNameTitle.setColor(Color.black);
        UserNameTitle.setFont(titleFont1);
        UserNameTitle.drawString("欢迎您，赵铁柱先生", getWidth("欢迎您，赵铁柱先生",14), H_title+45);


        //***********************邀请人数信息
        Graphics userNumTitle = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        userNumTitle.setColor(Color.black);
        //设置字体
        UserNameTitle.setFont(titleFont2);
        UserNameTitle.drawString("邀请人数", 50, H_title+90);

        Graphics userNum = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        userNum.setColor(Color.black);
        //设置字体
        userNum.setFont(titleFont2);
        userNum.drawString("5人", 200, H_title+90);

        //***********************有效期信息
        Graphics timeTitle = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        timeTitle.setColor(Color.black);
        //设置字体
        timeTitle.setFont(titleFont2);
        timeTitle.drawString("有 效 期", 50, H_title+110);

        Graphics time = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        userNum.setColor(Color.black);
        //设置字体
        userNum.setFont(titleFont2);
        userNum.drawString("2019-01-29", 200, H_title+110);

        //***********************有效期信息
        Graphics plateNumTitle = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        plateNumTitle.setColor(Color.black);
        //设置字体
        plateNumTitle.setFont(titleFont2);
        plateNumTitle.drawString("车    牌", 50, H_title+130);

        Graphics plateNum = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        plateNum.setColor(Color.black);
        //设置字体
        plateNum.setFont(titleFont2);
        plateNum.drawString("川A88888", 200, H_title+130);

        //***********************插入二维码
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {}

        if(bimg!=null){
            mainPic.drawImage(bimg, 50, 200, 200, 200, null);
            mainPic.dispose();
        }

        //***********************访客姓名性别信息
        Graphics messageTitle = image.createGraphics();
        //设置字体颜色，先设置颜色，再填充内容
        messageTitle.setColor(Color.black);
        messageTitle.setFont(titleFont2);
        messageTitle.drawString("进入小区，将通行码交给门岗扫描后通行", getWidth("进入小区，将通行码交给门岗扫描后通行",12), 430);

        createImage("C:\\Users\\E465\\Desktop\\二维码生成\\297a59a2-a03d-425a-a6d5-a071a3e64405.png");

    }


    private int getWidth(String str,int fontSize){
        int width = 0;
        if(str != null){
            int strLength = str.length();
            width = (imageWidth - (fontSize * strLength)) / 2;
        }
        return width;
    }

    public static void main(String[] args) {
        ChartGraphics cg = new ChartGraphics();
        try {
            cg.graphicsGeneration("ewew", "1", "12", "C:\\Users\\E465\\Desktop\\二维码生成\\ceb9a3e7-b31f-4764-938e-35204a985acf.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}