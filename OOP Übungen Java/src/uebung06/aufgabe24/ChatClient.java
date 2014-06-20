package uebung06.aufgabe24;

import static uebung06.aufgabe24.ChatServerImpl.SERVER_NAME;
import static uebung06.aufgabe24.ChatServerImpl.SERVER_PORT;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChatClient {

	private static final String MESSAGE_TEXT = "Nachricht: ";

	private Scanner scanner;
	private String nickname;

	private ChatServer server;
	private ClientHandle handle;
	private ChatSession session;

	public ChatClient(String pNickname) throws Exception {
		scanner = new Scanner(System.in);
		nickname = pNickname;
		server = (ChatServer) LocateRegistry.getRegistry(SERVER_PORT).lookup(SERVER_NAME);
		handle = new ClientHandleImpl(this);
		session = server.createSession(nickname, handle);
		if (session == null) {
			System.out.println("Nickname already exists.");
			close();
		}
		for (Message message : server.getLastMessages()) {
			System.out.println(message.toString());
		}
		run();
	}

	private void run() throws RemoteException {
		while (true) {
			System.out.print(MESSAGE_TEXT);
			String message = scanner.nextLine().trim();
			if ("close".equals(message.toLowerCase())) {
				close();
			} else if ("users".equals(message.toLowerCase())) {
				showUsers();
				continue;
			}
			sendMessage(message);
		}
	}

	private void showUsers() throws RemoteException {
		System.out.println("Users:");
		for (String user : server.getUsers()) {
			System.out.println(" - " + user);
		}
	}

	public void receiveMessage(Message message) {
		System.out.print("\r" + message.toString() + "\n" + MESSAGE_TEXT);
	}

	public void close() throws RemoteException {
		server.removeSession(session);
		if (scanner != null) {
			scanner.close();
		}
		System.exit(0);
	}

	private void sendMessage(String messageString) throws RemoteException {
		String recipient = null;
		int index = messageString.indexOf(":");
		if (messageString.startsWith("@") && index > 0) {
			recipient = messageString.substring(1, index);
		}
		messageString = messageString.substring(index + 1).trim();
		if ("".equals(messageString)) {
			System.out.println("empty message...");
			return;
		}
		Message message = new Message(messageString, nickname, recipient);
		session.sendMessage(message);
		System.out.println(message.toString());
	}

	public static void main(String[] args) {
		try {
			String name = JOptionPane.showInputDialog(null, "Eingabe des Nickname");
			if (name != null && name.trim().length() > 1) {
				new ChatClient(name);
			} else {
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Nickname mit mehr als 1 Zeichen ein.");
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}
}
