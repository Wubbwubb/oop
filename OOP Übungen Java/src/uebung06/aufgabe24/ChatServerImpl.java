package uebung06.aufgabe24;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import uebung04.aufgabe16.RingBuffer;

public class ChatServerImpl extends UnicastRemoteObject implements ChatServer {

	private static final long serialVersionUID = -9032577462939581208L;

	public static final String SERVER_NAME = "ChatServer";
	public static final int SERVER_PORT = Registry.REGISTRY_PORT;

	private List<ChatSession> sessions = new LinkedList<>();
	private RingBuffer<Message> lastMessages = new RingBuffer<>(20);

	protected ChatServerImpl(int port) throws RemoteException {
		super(port);
	}

	@Override
	public ChatSession createSession(String nickname, ClientHandle handle) throws RemoteException {
		System.out.println("create session: " + nickname);
		for (ChatSession session : sessions) {
			if (nickname.equals(session.getNickname())) {
				return null;
			}
		}
		ChatSession s = new ChatSessionImpl(this, nickname, handle);
		sessions.add(s);
		return s;
	}

	public void postMessage(Message message, ChatSessionImpl s) throws RemoteException {
		ChatSessionImpl tmp;
		if (!message.isPrivate()) {
			lastMessages.add(message);
		}
		for (int i = 0; i < sessions.size(); i++) {
			tmp = (ChatSessionImpl) sessions.get(i);
			if ((message.isPrivate() && !message.getRecipient().equals(tmp.getNickname()))
					|| tmp.getNickname().equals(message.getSender())) {
				continue;
			}
			try {
				tmp.getClientHandle().receiveMessage(message);
			} catch (RemoteException ex) {
				System.out.println("unabled to contact client " + s.getNickname());
				System.out.println("removing.");
				removeSession(tmp);
				i--; // Da nun alle Clients in Liste einen Platz nach unten rutschen ...
			}
		}
	}

	@Override
	public void removeSession(ChatSession session) throws RemoteException {
		System.out.println("remove session for user: " + session.getNickname());
		sessions.remove(session);
	}

	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(SERVER_PORT);
			LocateRegistry.getRegistry().rebind(SERVER_NAME, new ChatServerImpl(SERVER_PORT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Collection<String> getUsers() throws RemoteException {
		Collection<String> users = new LinkedList<>();
		for (ChatSession session : sessions) {
			users.add(session.getNickname());
		}
		return users;
	}

	@Override
	public Collection<Message> getLastMessages() throws RemoteException {
		return Arrays.asList(lastMessages.toArray(new Message[lastMessages.size()]));
	}

}
