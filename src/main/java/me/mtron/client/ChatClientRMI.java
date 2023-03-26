//package me.mtron.client;
//
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.rmi.RemoteException;
//import javax.swing.BorderFactory;
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.border.Border;
//
//public class ChatClientRMI extends JFrame implements ActionListener {
//    private static final long serialVersionUID = 1L;
//    private JPanel textPanel;
//    private JPanel inputPanel;
//    private JTextField textField;
//    private String name;
//    private String message;
//    private Font meiryoFont = new Font("Meiryo", 0, 14);
//    private Border blankBorder = BorderFactory.createEmptyBorder(10, 10, 20, 10);
//    private ChatClient chatClient;
//    private JList<String> list;
//    private DefaultListModel<String> listModel;
//    protected JTextArea textArea;
//    protected JTextArea userArea;
//    protected JFrame frame = new JFrame("Client Chat Console");
//    protected JButton privateMsgButton;
//    protected JButton startButton;
//    protected JButton sendButton;
//    protected JPanel clientPanel;
//    protected JPanel userPanel;
//
//    public static void main(String[] args) {
//        try {
//            UIManager.LookAndFeelInfo[] var4;
//            int var3 = (var4 = UIManager.getInstalledLookAndFeels()).length;
//
//            for(int var2 = 0; var2 < var3; ++var2) {
//                UIManager.LookAndFeelInfo info = var4[var2];
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception var5) {
//        }
//
//        new ChatClientRMI();
//    }
//
//    public ChatClientRMI() {
//        this.frame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent windowEvent) {
//                if (ChatClientRMI.this.chatClient != null) {
//                    try {
//                        ChatClientRMI.this.sendMessage("Bye all, I am leaving");
//                        ChatClientRMI.this.chatClient.serverIF.leaveChat(ChatClientRMI.this.name);
//                    } catch (RemoteException var3) {
//                        var3.printStackTrace();
//                    }
//                }
//
//                System.exit(0);
//            }
//        });
//        Container c = this.getContentPane();
//        JPanel outerPanel = new JPanel(new BorderLayout());
//        outerPanel.add(this.getInputPanel(), "Center");
//        outerPanel.add(this.getTextPanel(), "North");
//        c.setLayout(new BorderLayout());
//        c.add(outerPanel, "Center");
//        c.add(this.getUsersPanel(), "West");
//        this.frame.add(c);
//        this.frame.pack();
//        this.frame.setAlwaysOnTop(true);
//        this.frame.setLocation(150, 150);
//        this.textField.requestFocus();
//        this.frame.setDefaultCloseOperation(3);
//        this.frame.setVisible(true);
//    }
//
//    public JPanel getTextPanel() {
//        String welcome = "Welcome enter your name and press Start to begin\n";
//        this.textArea = new JTextArea(welcome, 14, 34);
//        this.textArea.setMargin(new Insets(10, 10, 10, 10));
//        this.textArea.setFont(this.meiryoFont);
//        this.textArea.setLineWrap(true);
//        this.textArea.setWrapStyleWord(true);
//        this.textArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(this.textArea);
//        this.textPanel = new JPanel();
//        this.textPanel.add(scrollPane);
//        this.textPanel.setFont(new Font("Meiryo", 0, 14));
//        return this.textPanel;
//    }
//
//    public JPanel getInputPanel() {
//        this.inputPanel = new JPanel(new GridLayout(1, 1, 5, 5));
//        this.inputPanel.setBorder(this.blankBorder);
//        this.textField = new JTextField();
//        this.textField.setFont(this.meiryoFont);
//        this.inputPanel.add(this.textField);
//        return this.inputPanel;
//    }
//
//    public JPanel getUsersPanel() {
//        this.userPanel = new JPanel(new BorderLayout());
//        String userStr = " Current Users      ";
//        JLabel userLabel = new JLabel(userStr, 0);
//        this.userPanel.add(userLabel, "North");
//        userLabel.setFont(new Font("Meiryo", 0, 16));
//        String[] noClientsYet = new String[]{"No other users"};
//        this.setClientPanel(noClientsYet);
//        this.clientPanel.setFont(this.meiryoFont);
//        this.userPanel.add(this.makeButtonPanel(), "South");
//        this.userPanel.setBorder(this.blankBorder);
//        return this.userPanel;
//    }
//
//    public void setClientPanel(String[] currClients) {
//        this.clientPanel = new JPanel(new BorderLayout());
//        this.listModel = new DefaultListModel();
//        String[] var5 = currClients;
//        int var4 = currClients.length;
//
//        for(int var3 = 0; var3 < var4; ++var3) {
//            String s = var5[var3];
//            this.listModel.addElement(s);
//        }
//
//        if (currClients.length > 1) {
//            this.privateMsgButton.setEnabled(true);
//        }
//
//        this.list = new JList(this.listModel);
//        this.list.setSelectionMode(2);
//        this.list.setVisibleRowCount(8);
//        this.list.setFont(this.meiryoFont);
//        JScrollPane listScrollPane = new JScrollPane(this.list);
//        this.clientPanel.add(listScrollPane, "Center");
//        this.userPanel.add(this.clientPanel, "Center");
//    }
//
//    public JPanel makeButtonPanel() {
//        this.sendButton = new JButton("Send ");
//        this.sendButton.addActionListener(this);
//        this.sendButton.setEnabled(false);
//        this.privateMsgButton = new JButton("Send PM");
//        this.privateMsgButton.addActionListener(this);
//        this.privateMsgButton.setEnabled(false);
//        this.startButton = new JButton("Start ");
//        this.startButton.addActionListener(this);
//        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
//        buttonPanel.add(this.privateMsgButton);
//        buttonPanel.add(new JLabel(""));
//        buttonPanel.add(this.startButton);
//        buttonPanel.add(this.sendButton);
//        return buttonPanel;
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        try {
//            if (e.getSource() == this.startButton) {
//                this.name = this.textField.getText();
//                if (this.name.length() != 0) {
//                    this.frame.setTitle(this.name + "'s console ");
//                    this.textField.setText("");
//                    this.textArea.append("username : " + this.name + " connecting to chat...\n");
//                    this.getConnected(this.name);
//                    if (!this.chatClient.connectionProblem) {
//                        this.startButton.setEnabled(false);
//                        this.sendButton.setEnabled(true);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this.frame, "Enter your name to Start");
//                }
//            }
//
//            if (e.getSource() == this.sendButton) {
//                this.message = this.textField.getText();
//                this.textField.setText("");
//                this.sendMessage(this.message);
//                System.out.println("Sending message : " + this.message);
//            }
//
//            if (e.getSource() == this.privateMsgButton) {
//                int[] privateList = this.list.getSelectedIndices();
//
//                for(int i = 0; i < privateList.length; ++i) {
//                    System.out.println("selected index :" + privateList[i]);
//                }
//
//                this.message = this.textField.getText();
//                this.textField.setText("");
//                this.sendPrivate(privateList);
//            }
//        } catch (RemoteException var4) {
//            var4.printStackTrace();
//        }
//
//    }
//
//    private void sendMessage(String chatMessage) throws RemoteException {
//        this.chatClient.serverIF.updateChat(this.name, chatMessage);
//    }
//
//    private void sendPrivate(int[] privateList) throws RemoteException {
//        String privateMessage = "[PM from " + this.name + "] :" + this.message + "\n";
//        this.chatClient.serverIF.sendPM(privateList, privateMessage);
//    }
//
//    private void getConnected(String userName) throws RemoteException {
//        String cleanedUserName = userName.replaceAll("\\s+", "_");
//        cleanedUserName = userName.replaceAll("\\W+", "_");
//
//        try {
//            this.chatClient = new ChatClient(this, cleanedUserName);
//            this.chatClient.startClient();
//        } catch (RemoteException var4) {
//            var4.printStackTrace();
//        }
//
//    }
//}
