package my.JMS.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author  : J
 * @version : Aug 7, 2017  4:40:27 PM
 * 主题模式 --消息创建者
 */
public class AppProducer {

	private static final String URL = "tcp://192.168.101.105:61616";
	private static final String TOPIC_NAME = "queue_test";
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
		Destination destination = session.createTopic(TOPIC_NAME);
	
		// 6. 创建一个生产者
		MessageProducer producer = session.createProducer(destination);
		
		for(int i = 0; i < 100; i++){
			// 7. 创建消息
			TextMessage textMessage = session.createTextMessage("test " + i);
			// 8. 发布消息
			producer.send(textMessage);
			System.out.println("发送消息" + textMessage.getText());
			
		}
		
		// 9. 关闭连接
		connection.close();
	}
	
}
