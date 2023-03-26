package me.mtron.user;

import me.mtron.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChatArea extends JFrame{
    private JButton cHomeButton;
    private JPanel ChatArea;
    private JButton sendButton;
    private JTextField msgTextField;
    private JScrollPane scrollPane;
    private JTable myChattable;
    private JButton leaveChatButton;
    private JButton joinChatButton;
    private JLabel chatLable;
    private String userEmail;
    private String userNickName;
    private String userProPic;

    private JList<Message> chatList;
    private DefaultListModel<Message> chatListModel;

    private void SubscribeUserTable(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select c.chatName from SubscribeuserEntity s, ChatInfo c, User u where s.chatId = c.chat_id and s.userId = u.user_id and u.email = :email");
        query.setParameter("email", userEmail);
        List<String> chatNames = query.getResultList();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Chat Name");
        for (String chatName : chatNames) {
            Object[] row = {chatName};
            model.addRow(row);
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
                Message message = new Message(userNickName, messageContent);
                chatListModel.addElement(message);
                msgTextField.setText("");
                chatList.ensureIndexIsVisible(chatListModel.getSize()-1);
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
                    String chatName = myChattable.getValueAt(myChattable.getSelectedRow(), 0).toString();
                    chatLable.setText(chatName);
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

            if (message.getSenderName().equals(ChatArea.this.userNickName)) {
                senderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                messageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            } else {
                senderLabel.setHorizontalAlignment(SwingConstants.LEFT);
                messageLabel.setHorizontalAlignment(SwingConstants.LEFT);
            }

            return this;
        }
    }

    public static void main(String[] args) {
        new ChatArea("lisa@gmail.com", "Lisa", "src/main/resources/images/jane1.png");
    }

}
