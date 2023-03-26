package me.mtron.server;

import me.mtron.admin.ChatInfo;
import me.mtron.client.ChatClientITF;
import me.mtron.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ChatServer extends UnicastRemoteObject implements ChatServerITF {
    String line = "---------------------------------------------\n";
    private Vector<Chatter> chatters = new Vector(10, 1);
    private static final long serialVersionUID = 1L;
    private static final String LOG_FILE = "chat_log.txt";

    public ChatServer() throws RemoteException {
    }

    public static void main(String[] args) {
        startRMIRegistry();
        String hostName = "localhost";
        String serviceName;
        if (args.length == 2) {
            hostName = args[0];
            serviceName = args[1];
        }
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ChatInfo");
        List<ChatInfo> ChatInfoList = query.list();
        session.close();
        for (ChatInfo chatInfo : ChatInfoList) {
            serviceName = String.valueOf(chatInfo.getChat_id());
            ServerThread serverThread = new ServerThread(hostName, serviceName);
            serverThread.start();
        }

    }

    public static void startRMIRegistry() {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI Server ready");
        } catch (RemoteException var1) {
            var1.printStackTrace();
        }

    }

    public String sayHello(String ClientName) throws RemoteException {
        System.out.println(ClientName + " sent a message");
        return "Hello " + ClientName + " from group chat server";
    }

    public void updateChat(String name, String nextPost) throws RemoteException {
        String message = name + " : " + nextPost + "\n";
        this.sendToAll(message);
    }

    public void passIDentity(RemoteRef ref) throws RemoteException {
        try {
            System.out.println(this.line + ref.toString());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void registerListener(String[] details) throws RemoteException {
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(details[0] + " has joined the chat session");
        System.out.println(details[0] + "'s hostname : " + details[1]);
        System.out.println(details[0] + "'sRMI service : " + details[2]);
        this.registerChatter(details);
    }

    private void registerChatter(String[] details) {
        try {
            ChatClientITF nextClient = (ChatClientITF)Naming.lookup("rmi://" + details[1] + "/" + details[2]);
            this.chatters.addElement(new Chatter(details[0], nextClient));
            nextClient.messageFromServer("[Server] : Hello " + details[0] + " you are now free to chat.\n");
            this.sendToAll("[Server] : " + details[0] + " has joined the group.\n");
        } catch (MalformedURLException | NotBoundException | RemoteException var3) {
            var3.printStackTrace();
        }

    }

    public void sendToAll(String newMessage) {
        Iterator var3 = this.chatters.iterator();

        while(var3.hasNext()) {
            Chatter c = (Chatter)var3.next();

            try {
                c.getClient().messageFromServer(newMessage);

                FileWriter writer = new FileWriter(LOG_FILE, true);
                writer.write(newMessage + "\n");
                writer.close();
            } catch (RemoteException var5) {
                var5.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void leaveChat(String userName) throws RemoteException {
        Iterator var3 = this.chatters.iterator();

        while(var3.hasNext()) {
            Chatter c = (Chatter)var3.next();
            if (c.getName().equals(userName)) {
                System.out.println(this.line + userName + " left the chat session");
                System.out.println(new Date(System.currentTimeMillis()));
                this.chatters.remove(c);
                break;
            }
        }

    }

}
