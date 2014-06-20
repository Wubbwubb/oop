package uebung06.aufgabe24;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientHandle extends Remote {

	public void receiveMessage(Message message) throws RemoteException;

}
