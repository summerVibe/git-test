package my.IO流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author  : J
 * @version : May 10, 2017  10:15:03 PM
 * explain  : 对字节流封装后对文件进行读写：
 */
public class Stream_test2 {
	public static void main(String[] args) {
		File file = new File("C:/Users/E465/Desktop/t.txt");
		FileOutputStream out = null;
		BufferedOutputStream o = null;
		BufferedInputStream i = null;
		FileInputStream in = null;
		try {
			//FileOutputStream(file, true);true参数表示不覆盖原文件，直接在文件后面追加添加内容。
			out = new FileOutputStream(file, true);
			o = new BufferedOutputStream(out);
			String s = "hello,world!";
			o.write(s.getBytes());
			
			System.out.println("写入成功");

			in = new FileInputStream(file);
			i = new BufferedInputStream(in);
			
			byte[] b = new byte[20];
			i.read(b, 0, b.length);
			System.out.println(new String(b));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				o.flush();
				o.close();
				i.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
