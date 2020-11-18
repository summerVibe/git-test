package my.lottery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author LiuTeng
 *
 */
public class EnterConsole
{
	public Object printConsole(){
		System.out.print("请输入你要随机选取多少注，确认回车即可：");
		BufferedReader objBR = new BufferedReader(new InputStreamReader(System.in));
		String strValue = null;
		try
		{
			strValue = (String)objBR.readLine();
		}
		catch ( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strValue;
	}
}
