package my.netty_;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * @author  : J
 * @version : Aug 21, 2017  4:09:17 PM
 * explain  : 
 */
public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8080);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeInt(4);
		output.writeBytes("123456\r\n7890");
		output.flush();
		
		// 接收netty服务器的信息
		DataInputStream input = new DataInputStream(socket.getInputStream());
		// 读取信息长度
		int length = input.readInt();
		byte[] b = new byte[length];
		input.readFully(b, 0, length);
		System.out.println(new String(b));
		
		
		output.close();
	}
}
