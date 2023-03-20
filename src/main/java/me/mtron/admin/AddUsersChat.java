package me.mtron.admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUsersChat extends JFrame {
    private JPanel subscribeUserPanel;

    public AddUsersChat() {
        super("Add Users to Chat");
        this.setContentPane(subscribeUserPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        sHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUsersChat.this.dispose();
                new Dashboard();
            }
        });
    }
    private JButton sHomeButton;
    private JTable table2;
    private JTable table1;
    private JTextField sSUNTextField;
    private JTextField sSUDETextField;
    private JButton sSUSearchButton;
    private JButton button2;
    private JButton sSCResetButton;
    private JButton sSCSearchButton;
    private JTextField sSCNTextField;
    private JTextField sSCDITextField;
    private JTextField textField5;
    private JTextField textField6;
    private JButton resetButton;
    private JButton subscribeButton;
    private JButton sSUResetButton;
}
