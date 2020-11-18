package my.file_;

import java.io.File;
import java.io.IOException;

/**
 * 以数字重命名
 * @author hai
 *
 */
public class NumberRenamePolicy{

	public File rename(File f)
    {
        String name = f.getName();
        String ext = null;// 后缀名
        int dot = name.lastIndexOf(".");
        if(dot != -1)
        {
            ext = name.substring(dot);
        }
        String newName = System.currentTimeMillis() + random(6) + ext;
        // file.getParent -- 返回文件父目录路径。
        f = new File(f.getParent(), newName);
        while(!createNewFile(f)){// 如果文件存在 --
        	newName = System.currentTimeMillis() + random(6) + ext;
        	f = new File(f.getParent(), newName);
        	
        }
        return f;
    }

	public String rename2(File f) {
        String name = f.getName();
        String ext = null;// 后缀名
        int dot = name.lastIndexOf(".");
        if(dot != -1)
        {
            ext = name.substring(dot);
        }
        String newName = f.getParent()+ f.separator +System.currentTimeMillis() + random(6) + ext;
        
        return newName;
    }
	
    private boolean createNewFile(File f)
    {
        try
        {
        	// 没有文件就创建 返回true，有就返回false
            return f.createNewFile();// boolean createNewFile() 不存在返回true 存在返回false
        }
        catch(IOException ignored)
        {
            return false;
        }
    }
    
    /**
	 * 生成随机数
	 * @param number 生成的位数
	 * @return
	 */
	public static String random(int number){
		String str = "";
		for(int i = 0;i < number;++i){
			str += (int)(Math.random()*10);
		}
		return str;
	}

}
