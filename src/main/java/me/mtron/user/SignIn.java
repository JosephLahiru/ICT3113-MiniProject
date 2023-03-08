package me.mtron.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JDialog{
    private JTextField tfEmail;
    private JTextField tfUserName;
    private JTextField tfNickName;
    private JTextField tfProPic;
    private JButton clearButton;
    private JButton submitButton;
    private JPanel signInPanel;
    private JPasswordField pwdField;
    private JPasswordField pwdComField;
    private JLabel imageLabel;
    private String email, uName, nickName, proPic;
    private String password, passwordCom;

    public SignIn(JFrame parent) {
        super(parent);
        setTitle("SignIn");
        setContentPane(signInPanel);
        setMinimumSize(new Dimension(700, 480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clearing");
                tfEmail.setText("");
                tfUserName.setText("");
                tfNickName.setText("");
                pwdField.setText("");
                pwdComField.setText("");
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submitting");
                email = tfEmail.getText();
                uName = tfUserName.getText();
                nickName = tfNickName.getText();
                password = String.valueOf(pwdField.getPassword());
                passwordCom = String.valueOf(pwdComField.getPassword());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("yo");
        SignIn signIn = new SignIn(null);
    }
}
