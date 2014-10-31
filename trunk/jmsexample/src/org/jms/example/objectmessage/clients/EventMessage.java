/**
 * 
 */
package org.jms.example.objectmessage.clients;

import java.io.Serializable;

/**
 * @author asudar
 *
 */
public class EventMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int messageId;
	private String messageText;

	public EventMessage(int messageId, String messageText) {
		super();
		this.messageId = messageId;
		this.messageText = messageText;
	}

	public int getMessageId() {
		return messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	@Override
	public String toString() {
		return "EventMessage [messageId=" + messageId + ", messageText="
				+ messageText + "]";
	}

}
