package uebung06.aufgabe24;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ChatServer extends Remote {

	public ChatSession createSession(String nickname, ClientHandle handle) throws RemoteException;

	public void removeSession(ChatSession session) throws RemoteException;

	public Collection<String> getUsers() throws RemoteException;
	
	public Collection<Message> getLastMessages() throws RemoteException;

}
