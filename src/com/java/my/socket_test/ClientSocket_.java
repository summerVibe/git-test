package my.socket_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author  : J
 * @version : May 11, 2017  1:31:54 PM
 * explain  : 
 */
public class ClientSocket_ {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",11111);
		
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.write("哈哈，我是客户端");
		pw.flush();
		socket.shutdownInput();
		
		InputStream in = socket.getInputStream();
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader bf = new BufferedReader(ir);
		String info=null;
//		while (()){
//			
//		}
		
		
	}
	

}
