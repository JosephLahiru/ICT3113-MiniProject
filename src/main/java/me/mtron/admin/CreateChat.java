package me.mtron.admin;

import me.mtron.db.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateChat extends JFrame {
    private JPanel createChatPanel;
    private JTable viewChatTable;
    private JTextField textFieldChatName;
    private JButton addButton;
    private JButton resetButton;
    private JTextField textFieldChatDiscription;
    private JButton cHomeButton;

    public CreateChat() {
        super("Create Chat");
        this.setContentPane(createChatPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        cHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateChat.this.dispose();
                new Dashboard();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldChatName.setText("");
                textFieldChatDiscription.setText("");
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chatName = textFieldChatName.getText();
                String chatDiscription = textFieldChatDiscription.getText();
                if (chatName.isEmpty() || chatDiscription.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    ChatInfo chatInfo = new ChatInfo(chatName, chatDiscription);
                    JOptionPane.showMessageDialog(null, "Chat Created Successfully");
                    Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
                    session.beginTransaction();
                    session.persist(chatInfo);
                    session.getTransaction().commit();
                    session.close();
                }
                textFieldChatName.setText("");
                textFieldChatDiscription.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new CreateChat();
    }
}
