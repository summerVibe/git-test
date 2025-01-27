package my.加密解密.MD5;

import java.security.MessageDigest;

/**
 * @author J
 * @date 创建时间：Nov 5, 2017 - 10:30:29 AM
 * @version 1.0
 */
public class MD5Util {
	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}

	// 测试主函数
	public static void main(String args[]) {
		String s = new String("root");
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + string2MD5(s));
		System.out.println("加密的：" + convertMD5(s));
		System.out.println("解密的：" + convertMD5(convertMD5(s)));
		
		System.out.println("解密的222：" + convertMD5("'-'065"));
//		String ss = "ce9e8dc8a961356d7624f1f463edafb5";
//		String s1 = convertMD5(ss);
//		System.out.println("ss 解密的：" + convertMD5(ss));
//		System.out.println("ss ：" + convertMD5(convertMD5(s1)));
//		System.out.println(ss);
		// c592f2f3318028cc4e64503ad61e24e3
	}
}
