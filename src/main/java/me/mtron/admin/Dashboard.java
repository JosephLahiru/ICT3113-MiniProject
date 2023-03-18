package me.mtron.admin;

import javax.swing.*;

public class Dashboard extends JFrame {

    private JPanel dashboardPanel;
    private JButton createChatButton;
    private JButton subscribeUsersButton;
    private JButton unsubscribeUsersButton;
    private JButton removeUsersButton;

    public Dashboard() {
        super("Dashboard");
        this.setContentPane(dashboardPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}