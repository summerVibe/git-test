package my.socket_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * http://www.cnblogs.com/wisdo/p/5860001.html
 * @author  : J
 * @version : May 11, 2017  1:19:45 PM
 * explain  : 
 */
public class ServerSocket_ {
	public static void main(String[] args) throws IOException {
		ServerSocket so = new ServerSocket(11111);
		Socket socket = so.accept();
		InputStream in = socket.getInputStream();
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		String info = null;
		while((info = br.readLine()) != null){
			System.out.println("客户端：" + info);
		}
		
		socket.shutdownInput();
		
		OutputStream out = socket.getOutputStream();
		PrintWriter pr = new PrintWriter(out);
		pr.write("你好");
		pr.flush();
		
		pr.close();
		out.close();
		br.close();
		ir.close();
		in.close();
		socket.close();
		so.close();
		
	}
	
}
