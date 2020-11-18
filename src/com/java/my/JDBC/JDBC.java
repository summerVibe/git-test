package my.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBC implements Serializable{
	public static String name;
	public static String pwd;
	public static String url;
	static{
//		Properties pro = new Properties();
//		try {
//			pro.load(new FileInputStream("JDBC/mysql.properties"));
//			name = pro.getProperty("name");
//			pwd = pro.getProperty("pwd");
//			url = pro.getProperty("url");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			pro.clear();
//		}
		
		
		//mysql为属性文件名，放在包com.my.JDBC下，如果是放在src下，直接用test即可  
		ResourceBundle resource = ResourceBundle.getBundle("com/my/JDBC/mysql");
		name = resource.getString("name");  
		pwd = resource.getString("pwd");  
		url = resource.getString("url");  
		
	}
	
	public static Connection getConnection(){
		Connection co = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co =   DriverManager.getConnection(url,name, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return co;
	}
	public static void closeConnection(Connection co,Statement st,ResultSet rs){
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
			
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					st = null;
				}
			}
		
		if(co != null){
			try {
				co.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				co = null;
			}
		}
	}
}
