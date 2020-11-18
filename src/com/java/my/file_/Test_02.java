package my.file_;

import java.io.File;

import org.junit.Test;

/**
 * @author  : J
 * @version : Aug 11, 2017  10:25:43 AM
 * explain  : file类的常用方法：http://blog.csdn.net/shuaiby/article/details/19619585
 */
public class Test_02 {
	
	@Test
	public void testNumberRenamePolicy(){
		
		File file = new File("c:/Users/E465/Desktop/11.jpg");
		
//		System.out.println(file.separator); // 文件分隔符（在 UNIX 系统中是“/”），window 是"\" 
		
		// 这两种路径写法都可以;
//		file.renameTo(new File("c:/Users/thinkpad/Desktop/t1.txt"));
//		file.renameTo(new File("c:\\Users\\thinkpad\\Desktop\\t2.txt"));
		
		file.renameTo(new File(new NumberRenamePolicy().rename2(file)));// 重命名文件
		
		System.out.println("获取工程路径名   "+System.getProperty("user.dir")); // 获取工程路径名
		System.out.println("判断linux "+System.getProperty("file.separator").equals("/")); // 判断linux的方法。
		
		File f = new NumberRenamePolicy().rename(file);
		System.out.println("文件名   "+f.getName());// 获取文件名
		System.out.println("所在文件夹的路径   "+f.getParentFile());// 返回文件所在文件夹的路径。 
		System.out.println("文件父目录路径   "+file.getParent());// 返回文件父目录路径。
		System.out.println("文件是否可写   "+f.canWrite());// 返回文件是否可写。  
		System.out.println("文件是否可读   "+f.canRead());// 返回文件是否可读。
		System.out.println("删除文件   "+f.delete());// 删除文件
		
	}

}
