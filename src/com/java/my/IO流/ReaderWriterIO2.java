package my.IO流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author  : J
 * @version : May 10, 2017  10:20:45 PM
 * explain  : 对字符流封装后对文件进行读写：
 */
public class ReaderWriterIO2 {
	public static void main(String[] args) {
		File file = new File("c:/Users/thinkpad/Desktop/t.txt");
		try {
			FileWriter out = new FileWriter(file,true);
			BufferedWriter o = new BufferedWriter(out);
			String s = "你好世界!";
			o.write(s);
			o.flush();
			o.close();
			System.out.println("字符流 - 文件写入成功!");
			
			FileReader in = new FileReader(file);
			BufferedReader i = new BufferedReader(in);
			String str = "";
			String temp = null;
			while((temp = i.readLine()) != null){
				str = str + temp;
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
