package me.mtron.user;

import org.hibernate.Session;
import me.mtron.db.HibernateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SignIn extends JFrame{
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
    private JButton alreadyHaveAnAccountButton;
    private String email, uName, nickName, proPic;
    private String password, passwordCom;

    public SignIn(JFrame parent) {
        super("SignIn");

        this.setContentPane(signInPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

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

                if(Objects.equals(password, passwordCom)) {
                    User user = new User(email, uName, password, nickName);

                    Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
                    session.beginTransaction();
                    session.persist(user);
                    session.getTransaction().commit();
                    session.close();

                    Login login = new Login(null);
                    login.setVisible(true);
                    setVisible(false);
                }
            }
        });

        alreadyHaveAnAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn.this.dispose();
                new Login(null);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("SignIn");
        new SignIn(null);
    }
}
