package me.mtron.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUsersChat extends JFrame {
    private JButton sHomeButton;
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
}
