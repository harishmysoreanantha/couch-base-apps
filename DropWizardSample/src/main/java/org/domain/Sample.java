package org.domain;

public class Sample {

	private String message;

	public Sample() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sample [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

}
