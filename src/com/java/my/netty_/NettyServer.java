package my.netty_;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;


/**
 * @author  : J
 * @version : Aug 21, 2017  3:23:47 PM
 * explain  : http://www.itjoin.org/video/find/597c5931e4b0f96d0ae36373?serial=3&page=0
 */
public class NettyServer {
	public static void main(String[] args) throws InterruptedException {
		
		ServerBootstrap server = new ServerBootstrap();
		
//		1. 绑定两个线程组分别来处理客户端通道的accept 和读写事件;
		EventLoopGroup parentGroup = new NioEventLoopGroup();
		EventLoopGroup childGroup = new NioEventLoopGroup();
		server.group(parentGroup, childGroup);
		
//		2. 绑定服务端通道NioServerSocketChannel;
		server.channel(NioServerSocketChannel.class);
		
//		3. 给读写事件的线程通道绑定handler去真正处理读写;
		server.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				
				// 解码器
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder
						// 最大的长度,分隔符
						(Integer.MAX_VALUE,  Unpooled.wrappedBuffer(new byte[] { '\r','\n' })));
				
				// 长度解码器
//				ch.pipeline().addLast(new LengthFieldBasedFrameDecoder
//						// 最大的长度,长度值的偏移量，长度值的长度，长度的调节，跳过多少字节读取
//						(Integer.MAX_VALUE, 0, 4,0,4));
				
				
				// 业务逻辑处理
				ch.pipeline().addLast(new SimpleServerHander());
			
				
				// 编码器是倒着处理的(解码器是正常顺序)，先经过  StringEncoder()在经过 LengthFieldPrepender
				// TailContext  ----- (shift+ctrl+t查找)
				// 
				
				// 编码器,只能编码ByteBuf
				ch.pipeline().addLast(new LengthFieldPrepender
						// 长度值的长度，这个长度是否包含长度值
						(4, false));
				// http://stephen830.iteye.com/blog/2319169
				// 增加一个字符串编码器
				ch.pipeline().addLast(new StringEncoder());
				
				
			}
		});
		
//		4. 监听端口; 
		ChannelFuture future = server.bind(8080).sync();// 同步绑定，成功或失败
		// 
		future.channel().closeFuture().sync();
		
	}

}
