package my.IO流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * http://www.jb51.net/article/76485.htm
 * http://www.cnblogs.com/jun9207/p/5197697.html
 * 
 * @author : J
 * @version : May 10, 2017 9:31:00 PM explain : 运用字节流对文件进行直接读写
 */
public class Stream_test {
	public static void main(String[] args) {
		File file = new File("C:/Users/E465/Desktop/t.txt");
		FileOutputStream out = null;
		try {
			//FileOutputStream(file, true);true参数表示不覆盖原文件，直接在文件后面追加添加内容。
			out = new FileOutputStream(file, true);
			String s = "hello,world!";
			out.write(s.getBytes());
			out.flush();
			out.close();
			System.out.println("写入成功");

			FileInputStream in = new FileInputStream(file);
			byte[] b = new byte[20];
			in.read(b, 0, b.length);
			System.out.println(new String(b));
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
