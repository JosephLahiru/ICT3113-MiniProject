package me.mtron.server;

import java.rmi.Naming;

public class ServerThread extends Thread {
    private String hostName;
    private String serviceName;

    public ServerThread(String hostName, String serviceName) {
        this.hostName = hostName;
        this.serviceName = serviceName;
    }

    public void run() {
        try {
            ChatServerITF hello = new ChatServer();
            Naming.rebind("rmi://" + hostName + "/" + serviceName, hello);
            System.out.println("Group Chat RMI Server("+serviceName+") is running...");
        } catch (Exception var4) {
            System.out.println("Server had problems starting");
        }
    }
}
