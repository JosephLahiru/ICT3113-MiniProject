package me.mtron.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveUsersApplication extends JFrame {
    private JButton uHomeButton;
    private JPanel removeUserPanel;
    private JTextField rSUNTextField;
    private JTextField rSUDETextField;
    private JButton rSUSearchButton;
    private JButton rSUResetButton;
    private JTextField rRUETextField;
    private JButton rRUResetButton;
    private JButton rRUDeleteButton;
    private JTable rUUserTable;

    public RemoveUsersApplication() {
        super("Remove Users from Application");
        this.setContentPane(removeUserPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        uHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveUsersApplication.this.dispose();
                new Dashboard();
            }
        });
    }
}
