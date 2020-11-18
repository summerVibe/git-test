package my.netty_;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author  : J
 * @version : Aug 21, 2017  3:50:37 PM
 * explain  : 
 */
public class SimpleServerHander extends ChannelInboundHandlerAdapter {

	/**
	 *  读取客户端通道的数据
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		if(msg instanceof ByteBuf){
			System.out.println(((ByteBuf)msg).toString(Charset.defaultCharset()));
		}
	
		// ctx.channel() 获取通道
		ctx.channel().writeAndFlush("is ok");
	
	}
	
}
