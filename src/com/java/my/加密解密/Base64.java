package my.加密解密;
import java.io.IOException;


//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class Base64 {
    
    
/*	public static String encoder(String str){
		BASE64Encoder encoder = new BASE64Encoder();
		String encode = encoder.encode(str.getBytes());
		for(int i= 0;i<3;i++){
			encode = encoder.encode(encode.getBytes());
		}
        System.out.println("encode:  " + encode);
		return encode;
	}
	
	public static String decoder(String str){
		BASE64Decoder decoder = new BASE64Decoder();
		String decode = "";
		try {
			decode = new String ( decoder.decodeBuffer(str));
			for(int i= 0;i<3;i++){
				decode = new String ( decoder.decodeBuffer(decode));
			}
	        System.out.println("decode:  " + decode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return decode;
	}
	
	public static void main(String[] args) {
		encoder("xujun123@123鍝堝搱");
		decoder("V2xWb1YyTlhVbGhPU0doT1lXczFRbFJXVWtwbGFsWmhWREJyTVZkck9Vbz0=");
	}
*/
}