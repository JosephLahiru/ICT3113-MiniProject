package me.mtron.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatArea extends JFrame{
    private JButton cHomeButton;
    private JPanel ChatArea;

    public ChatArea() {
        super("ChatArea");
        this.setContentPane(ChatArea);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        cHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatArea.this.dispose();
                //new Dashboard();
            }
        });
    }
}
