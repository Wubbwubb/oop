package uebung06.aufgabe24;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatSessionImpl extends UnicastRemoteObject implements ChatSession {

	private static final long serialVersionUID = -4224114446312004471L;

	private ChatServerImpl server;
	private String nickname;
	private ClientHandle handle;

	public ChatSessionImpl() throws RemoteException {
	}

	public ChatSessionImpl(ChatServerImpl server, String nickname, ClientHandle handle) throws RemoteException {
		this.server = server;
		this.nickname = nickname;
		this.handle = handle;
	}

	@Override
	public void sendMessage(Message message) throws RemoteException {
		server.postMessage(message, this);
	}

	public ClientHandle getClientHandle() {
		return handle;
	}

	@Override
	public String getNickname() {
		return nickname;
	}

}
