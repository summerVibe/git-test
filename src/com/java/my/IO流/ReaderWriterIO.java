package my.IO流;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * http://www.jb51.net/article/76485.htm
 * http://www.cnblogs.com/jun9207/p/5197697.html
 * @author  : J
 * @version : May 10, 2017  10:02:36 PM
 * explain  : 运用字符流对文件进行直接读写
 */
public class ReaderWriterIO {
	public static void main(String[] args) {
		File file = new File("c:/Users/thinkpad/Desktop/t.txt");
		System.out.println(file.getParent());// 返回文件父目录路径。 --c:\Users\thinkpad\Desktop
		try {
			// http://www.cnblogs.com/huangyibo/p/3667714.html
			System.out.println(file.createNewFile());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			FileWriter out = new FileWriter(file,true);
			String s = "你好世界!";
			out.write(s);
			out.flush();
			out.close();
			System.out.println("字符流 - 文件写入成功!");
			
			FileReader in = new FileReader(file);
			char[] c = new char[40];
			in.read(c);
			System.out.println(" 读取：  "+new String(c));
			c.clone();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
