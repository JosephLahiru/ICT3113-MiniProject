package me.mtron.client;

import me.mtron.db.HibernateUtil;
import me.mtron.user.Dashboard;
import me.mtron.user.Message;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Objects;

public class ChatArea extends JFrame{
    private JButton cHomeButton;
    private JPanel ChatArea;
    private JButton sendButton;
    public JTextField msgTextField;
    public JScrollPane scrollPane;
    private JTable myChattable;
    private JButton leaveChatButton;
    private JButton joinChatButton;
    private JLabel chatLable;
    private String userEmail;
    public String userNickName;
    private String userProPic;
    private String chatid;

    ChatClient chatClient;

    public JList<Message> chatList;
    public DefaultListModel<Message> chatListModel;

    private void SubscribeUserTable(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select c.chat_id, c.chatName from SubscribeuserEntity s, ChatInfo c, User u where s.chatId = c.chat_id and s.userId = u.user_id and u.email = :email");
        query.setParameter("email", userEmail);
        List<Object[]> chatinfo = query.getResultList();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Chat ID");
        model.addColumn("Chat Name");
        for (Object[] chat : chatinfo) {
            model.addRow(new Object[]{chat[0], chat[1]});
        }
        myChattable.setModel(model);
    }

    public ChatArea(String email, String nickname, String user_image) {
        super("ChatArea");

        this.userEmail = email;
        this.userNickName = nickname;
        this.userProPic = user_image;

        this.setContentPane(ChatArea);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        SubscribeUserTable();

        chatListModel = new DefaultListModel<>();
        chatList = new JList<>(chatListModel);
        scrollPane.setViewportView(chatList);

        chatList.setCellRenderer(new MessageCellRenderer());

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String messageContent = msgTextField.getText();
                try {
                    sendMessage(messageContent);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
//                Message message = new Message(userNickName, messageContent);
//                chatListModel.addElement(message);
//                msgTextField.setText("");
//                chatList.ensureIndexIsVisible(chatListModel.getSize()-1);
            }
        });

        cHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatArea.this.dispose();
                new Dashboard(userEmail, userNickName, userProPic);
            }
        });
        joinChatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myChattable.getSelectedRow() != -1){
                    String chatName = myChattable.getValueAt(myChattable.getSelectedRow(), 1).toString();
                    chatid = myChattable.getValueAt(myChattable.getSelectedRow(), 0).toString();
                    chatLable.setText(chatName);
                    try {
                        getConnected(userNickName);
                    } catch (RemoteException ex) {
                        throw new RuntimeException(ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please select a chat to join");
                }

            }
        });
    }

    // A custom cell renderer for the chat messages
    private class MessageCellRenderer extends JPanel implements ListCellRenderer<Message> {
        private JLabel senderLabel;
        private JLabel messageLabel;

        public MessageCellRenderer() {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            senderLabel = new JLabel();
            senderLabel.setFont(senderLabel.getFont().deriveFont(14f).deriveFont(Font.BOLD));
            senderLabel.setForeground(Color.BLUE);
            messageLabel = new JLabel();
            messageLabel.setFont(messageLabel.getFont().deriveFont(16f));
            add(senderLabel, BorderLayout.NORTH);
            add(messageLabel, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Message> list, Message message, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            senderLabel.setText(message.getSenderName());
            messageLabel.setText(message.getMessageContent());
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            senderLabel.setHorizontalAlignment(SwingConstants.LEFT);
            messageLabel.setHorizontalAlignment(SwingConstants.LEFT);

            return this;
        }
    }

    private void sendMessage(String chatMessage) throws RemoteException {
        this.chatClient.serverIF.updateChat(this.userNickName, chatMessage);
    }

    private void getConnected(String userName) throws RemoteException {
        String cleanedUserName = userName.replaceAll("\\s+", "_");
        cleanedUserName = userName.replaceAll("\\W+", "_");

        try {
            System.out.println(chatid);
            this.chatClient = new ChatClient(this, cleanedUserName, this.chatid);
            this.chatClient.startClient();
        } catch (RemoteException var4) {
            var4.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ChatArea("adam@gmail.com", "Adam", "src/main/resources/images/jane1.png");
    }

}
