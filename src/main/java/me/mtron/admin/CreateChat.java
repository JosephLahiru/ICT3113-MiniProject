package me.mtron.admin;

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
    private JButton button1;

    public CreateChat() {
        super("Create Chat");
        this.setContentPane(createChatPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dashboard();
            }
        });
    }

    public static void main(String[] args) {
        new CreateChat();
    }
}
