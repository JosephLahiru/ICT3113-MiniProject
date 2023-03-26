package me.mtron.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientITF extends Remote {
    void messageFromServer(String var1) throws RemoteException;

}
