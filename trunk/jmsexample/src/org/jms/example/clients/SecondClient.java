/**
 * 
 */
package org.jms.example.clients;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author asudar
 *
 */
public class SecondClient {

	Context context = null;
	ConnectionFactory connectionFactory = null;
	Connection connection = null;
	MessageConsumer messageConsumer = null;
	Destination destination = null;
	Session session = null;

	public void recevieMessage() {
		Properties properties = new Properties();
		properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.exolab.jms.jndi.InitialContextFactory");
		properties.put(InitialContext.PROVIDER_URL, "tcp://localhost:3035");
		
		
			try {
				context = new InitialContext(properties);
				connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
				destination = (Destination) context.lookup("queue1");
				connection = connectionFactory.createConnection();
				session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				messageConsumer = session.createConsumer(destination);
				connection.start();
				Message message =  messageConsumer.receive();
				
				if(message instanceof TextMessage) {
					TextMessage msg = (TextMessage) message;
					System.out.println("Message is : "+msg.getText());
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				e.printStackTrace();
			}finally {
				if(context!=null) {
					try {
						context.close();
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
				
				if(connection!=null) {
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

		SecondClient secondClient = new SecondClient();
		secondClient.recevieMessage();
	}

}
