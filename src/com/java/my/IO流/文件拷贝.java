package my.IO流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 文件拷贝 {
	
	public static void copy(File f1,File f2) throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			byte[] b = new byte[1024];
			int byteReader = 0;
			while((byteReader = in.read(b)) > 0){
				out.write(b, 0, byteReader);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			in.close();
			out.close();
		}
		
	}
	
	public static void main(String[] args){
		File f1 = new File("C:\\Users\\E465\\Desktop\\job.properties");
		File f2 = new File("C:\\Users\\E465\\Desktop\\job_____.properties");
		try {
			copy( f1, f2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
