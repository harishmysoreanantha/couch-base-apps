/**
 * 
 */
package org.jms.example.clients;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author asudar
 *
 */
public class FirstClient {

	Context context = null;
	ConnectionFactory connectionFactory = null;
	Connection connection = null;
	Destination destination = null;
	Session session = null;
	MessageProducer messageProducer = null;

	public void sendMessage() {
		Properties properties = new Properties();
		properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.exolab.jms.jndi.InitialContextFactory");
		properties.put(InitialContext.PROVIDER_URL, "tcp://localhost:3035");

		try {
			context = new InitialContext(properties);
			connectionFactory = (ConnectionFactory) context
					.lookup("ConnectionFactory");
			destination = (Destination) context.lookup("queue1");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			messageProducer = session.createProducer(destination);
			connection.start();

			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("This is Sample Message from First Client");
			messageProducer.send(textMessage);

			System.out.println("Sent : " + textMessage.getText());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FirstClient firstClient = new FirstClient();
		firstClient.sendMessage();
	}

}
