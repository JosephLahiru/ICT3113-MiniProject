package me.mtron.admin;

import javax.swing.*;

public class CreateChat extends JFrame {
    private JPanel createChatPanel;
    private JTable viewChatTable;
    private JTextField textFieldChatName;
    private JButton addButton;
    private JButton resetButton;
    private JTextField textFieldChatDiscription;

    public CreateChat() {
        super("Create Chat");
        this.setContentPane(createChatPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CreateChat();
    }
}
