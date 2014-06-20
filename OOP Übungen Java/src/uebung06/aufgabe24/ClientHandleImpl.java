package uebung06.aufgabe24;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientHandleImpl extends UnicastRemoteObject implements ClientHandle {

	private static final long serialVersionUID = -1549863618295468563L;

	private ChatClient client;

	public ClientHandleImpl(ChatClient client) throws RemoteException {
		this.client = client;
	}

	@Override
	public void receiveMessage(Message message) {
		client.receiveMessage(message);
	}

}
