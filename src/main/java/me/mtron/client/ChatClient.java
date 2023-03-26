package me.mtron.client;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
import me.mtron.server.ChatServerITF;
import me.mtron.user.Message;

public class ChatClient extends UnicastRemoteObject implements ChatClientITF {
    private static final long serialVersionUID = 7468891722773409712L;
    ChatArea chatGUI;
    ChatArea chatArea;
    private String hostName = "localhost";
    private String serviceName = "GroupChatService";
    private String clientServiceName;
    private String name;
    protected ChatServerITF serverIF;
    protected boolean connectionProblem = false;

    public ChatClient(ChatArea aChatGUI, String userName) throws RemoteException {
        this.chatGUI = aChatGUI;
        this.name = userName;
        this.clientServiceName = "ClientListenService_" + userName;
    }

    public void startClient() throws RemoteException {
        String[] details = new String[]{this.name, this.hostName, this.clientServiceName};

        try {
            Naming.rebind("rmi://" + this.hostName + "/" + this.clientServiceName, this);
            this.serverIF = (ChatServerITF)Naming.lookup("rmi://" + this.hostName + "/" + this.serviceName);
        } catch (ConnectException var3) {
            JOptionPane.showMessageDialog(this.chatGUI.scrollPane, "The server seems to be unavailable\nPlease try later", "Connection problem", 0);
            this.connectionProblem = true;
            var3.printStackTrace();
        } catch (MalformedURLException | NotBoundException var4) {
            this.connectionProblem = true;
            var4.printStackTrace();
        }

        if (!this.connectionProblem) {
            this.registerWithServer(details);
        }

        System.out.println("Client Listen RMI Server is running...\n");
    }

    public void registerWithServer(String[] details) {
        try {
            this.serverIF.passIDentity(this.ref);
            this.serverIF.registerListener(details);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void messageFromServer(String message) throws RemoteException {
        Message msg = new Message("Server", message);
        this.chatGUI.chatListModel.addElement(msg);
        this.chatGUI.msgTextField.setText("");
        this.chatGUI.chatList.ensureIndexIsVisible(this.chatGUI.chatListModel.getSize()-1);
    }

    @Override
    public void updateUserList(String[] var1) throws RemoteException {

    }

//    public void updateUserList(String[] currentUsers) throws RemoteException {
//        if (currentUsers.length < 2) {
//            this.chatGUI.privateMsgButton.setEnabled(false);
//        }
//
//        this.chatGUI.userPanel.remove(this.chatGUI.clientPanel);
//        this.chatGUI.setClientPanel(currentUsers);
//        this.chatGUI.clientPanel.repaint();
//        this.chatGUI.clientPanel.revalidate();
//    }
}