package uebung06.aufgabe24;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 924513111497154289L;

	private String message;
	private String sender;
	private String recipient;

	public Message(String message, String sender, String recipient) {
		setMessage(message);
		setSender(sender);
		setRecipient(recipient);
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	private void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	private void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public boolean isPrivate() {
		return getRecipient() != null;
	}

	@Override
	public String toString() {
		String res = getSender();
		if (isPrivate()) {
			res += " (private)";
		}
		res += ": " + getMessage();
		return res;
	}

}
