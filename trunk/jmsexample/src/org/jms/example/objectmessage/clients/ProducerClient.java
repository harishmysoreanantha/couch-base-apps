/**
 * 
 */
package org.jms.example.objectmessage.clients;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author asudar
 *
 */
public class ProducerClient {

	Context context = null;
	ConnectionFactory connectionFactory = null;
	Connection connection = null;
	MessageProducer messageProducer = null;
	Destination destination = null;
	Session session = null;

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

			EventMessage eventMessage = new EventMessage(111, "Sample Message");
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(eventMessage);

			connection.start();

			messageProducer.send(objectMessage);

			System.out.println(this.getClass().getName() + " sent a Message "
					+ eventMessage);

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

		ProducerClient producerClient = new ProducerClient();
		producerClient.sendMessage();
	}

}
