package my.JDBC;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 应用程序中访问存储函数和存储过程
 * 慕课网 ：http://www.imooc.com/video/7296
 * 
 * @author  : J
 * @version : Apr 19, 2017  4:32:13 PM
 * explain  : 
 */
public class Test {
	public static void main(String[] args) {
		JDBC jdbc = new JDBC();
		Connection connection = jdbc.getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			// update  users set user_name='tttt' where user_id=100
			String sql = "insert into users values(4,'t4','333',1);"
					+ "insert into users values(5,'t5','333',1);";
			int rows = st.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeConnection(connection,st,null);
		}
	}
	
	
	
	
	
}
