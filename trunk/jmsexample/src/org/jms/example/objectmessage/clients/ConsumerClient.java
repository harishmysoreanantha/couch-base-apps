/**
 * 
 */
package org.jms.example.objectmessage.clients;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author asudar
 *
 */
public class ConsumerClient {

	Context context = null;
	ConnectionFactory connectionFactory = null;
	Connection connection = null;
	Destination destination = null;
	MessageConsumer messageConsumer = null;
	Session session = null;

	public void readMessage() {
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
			messageConsumer = session.createConsumer(destination);

			connection.start();
			Message message = messageConsumer.receive();

			if (message instanceof ObjectMessage) {
				Object object = ((ObjectMessage) message).getObject();
				EventMessage eventMessage = (EventMessage) object;
				System.out.println("Recived Message is : " + eventMessage);
			}
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
		ConsumerClient consumerClient = new ConsumerClient();
		consumerClient.readMessage();
	}

}
