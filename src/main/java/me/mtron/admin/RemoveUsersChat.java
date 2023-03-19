package me.mtron.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUsersChat extends JFrame{
    private JPanel unsubscribeUserPanel;
    private JButton uHomeButton;

    public RemoveUsersChat() {
        super("Unsubscribe Users from Chat");
        this.setContentPane(unsubscribeUserPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        uHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveUsersChat.this.dispose();
                new Dashboard();
            }
        });
    }


}
