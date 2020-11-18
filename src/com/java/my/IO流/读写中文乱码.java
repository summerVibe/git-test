package my.IO流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author : J
 * @version : Jul 18, 2017 10:52:46 AM explain :
 */
public class 读写中文乱码 {
	public static void main(String[] args) {
		File fileIn = new File("E:\\TEST\\readText.txt");
		File fileOut = new File("E:\\TEST\\readText2.txt");

		InputStreamReader inStream = null;
		OutputStreamWriter writerStream = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			// 读取中文时需要用GBK,否则会出现乱码
			inStream = new InputStreamReader(new FileInputStream(fileIn), "GBK");
			writerStream = new OutputStreamWriter(new FileOutputStream(fileOut), "GBK");

			reader = new BufferedReader(inStream);
			writer = new BufferedWriter(writerStream);
			String lineWriter = null;
			while ((lineWriter = reader.readLine()) != null) {
				writer.write(lineWriter);
				writer.newLine();
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
