package my.QrCode;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;



// https://www.cnblogs.com/aston/p/7501895.html
//生成二维码
public class QrCodeUtil2 {

	public static Integer createQrCode(String content){
		final int width = 200;
		final int height = 200;
		final String format = "png";

		//定义二维码的参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);

		//生成二维码
		try{
			//OutputStream stream = new OutputStreamWriter();
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("C:\\Users\\E465\\Desktop\\二维码生成\\"+ UUID.randomUUID().toString()+".png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			//MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
		}catch(Exception e){

		}
		return 0;
	}


	public static String readQrCode(String url) throws Exception {
		MultiFormatReader formatReader = new MultiFormatReader();
		File file = new File(url);

		BufferedImage image = ImageIO.read(file);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

		//定义二维码的参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

		Result result = formatReader.decode(binaryBitmap, hints);

		System.out.println("二维码解析结果：" + result.toString());
		System.out.println("二维码的格式：" + result.getBarcodeFormat());
		System.out.println("二维码的文本内容：" + result.getText());
		return result.getText();
	}

	public static void main(String[] args) throws Exception {
		createQrCode("漫生活邀请码！！！！");

	}

}