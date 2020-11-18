package my.JMS.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author  : J
 * @version : Aug 7, 2017  5:11:41 PM
 * explain  : 队列模式 --消费者
 */
public class AppConsumer {
	
	private static final String URL = "tcp://192.168.101.105:61616";
	private static final String QUEUE_NAME = "queue_test";
	public static void main(String[] args) throws JMSException {
		// 1. 创建ConnectionFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
	
		// 2. 创建Connection
		Connection connection = connectionFactory.createConnection();
		
		// 3. 启动连接
		connection.start();
		
		// 4. 创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 5. 创建一个目标
		Destination destination = session.createQueue(QUEUE_NAME);
	
		// 6.创建一个消费者
		MessageConsumer consumer = session.createConsumer(destination);
		
		// 7. 创建一个监听器
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("接收消息" + textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		// 9. 关闭连接
		// 消息监听是异步的，还没接收到消息就关闭了连接，将会报错， 连接需要在程序退出关闭；
//		connection.close();
	}
	
}
