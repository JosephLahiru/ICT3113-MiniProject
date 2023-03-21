package me.mtron.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatArea extends JFrame{
    private JButton cHomeButton;
    private JPanel ChatArea;
    private JButton sendButton;
    private JTextField msgTextField;
    private JScrollPane scrollPane;
    private String userEmail;
    private String userNickName;
    private String userProPic;

    private JList<Message> chatList;
    private DefaultListModel<Message> chatListModel;

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

}
