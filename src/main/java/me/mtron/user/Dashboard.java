package me.mtron.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel Dashboard;
    private JButton chatAreaButton;
    private JButton searchChatsButton;

    public Dashboard() {
        super("Dashboard");
        this.setContentPane(Dashboard);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        chatAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChatArea();
                Dashboard.this.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
