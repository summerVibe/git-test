package my.QrCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QrCodeUtil {
	public static void encode(String filePath,int width,String content) throws Exception{
		File file = new File(filePath);
		if(file!=null && file.getParentFile() != null && !file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		
		int index = filePath.lastIndexOf(".");
		String format = filePath.substring(index+1);
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,  
                BarcodeFormat.QR_CODE, width, width, hints);// 生成矩阵  
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像  
	}
	
	public static void encode(OutputStream out,int width, String content) throws Exception{
		String format = "jpg";
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,  
                BarcodeFormat.QR_CODE, width, width, hints);// 生成矩阵  
        MatrixToImageWriter.writeToStream(bitMatrix, format, out);
	}
	
	public static String decode(String filePath) throws Exception{
		BufferedImage image = ImageIO.read(new File(filePath));  
        LuminanceSource source = new BufferedImageLuminanceSource(image);  
        Binarizer binarizer = new HybridBinarizer(source);  
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
        Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();  
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
        Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码  
        return result.getText();  
	}
	
	public static void main(String[] args) throws Exception {
		File file = new File("d:\\2.jpg");
		encode(file.getAbsolutePath(), 200, "{\"itvuuid\":\"b51b61ba-7b06-4976-a286-a785e4200036\"}");

//		System.out.println(UUID.randomUUID().toString());
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		encode(out, 200, "{\"itvuuid\":\"b51b61ba-7b06-4976-a286-a785e4200036\"}");
//		System.out.println(Base64.encodeBase64String(out.toByteArray()));
//		out.close();

//		SimpleDateFormat formart = new SimpleDateFormat("yyMMddHHmm");
//		String dateStr = formart.format(new Date());
//		System.out.println(DigestUtils.md5Hex(dateStr+"hd_admin"));
//		System.out.println(DigestUtils.md5Hex(dateStr+"hd_iptv_001"));
	}
}
