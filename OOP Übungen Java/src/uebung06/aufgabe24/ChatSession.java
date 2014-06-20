package uebung06.aufgabe24;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatSession extends Remote {

	public void sendMessage(Message message) throws RemoteException;

	public String getNickname() throws RemoteException;

}
