package me.mtron.user;

import org.hibernate.Session;
import me.mtron.db.HibernateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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
        setResizable(false);

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
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("SignIn");
        SignIn signIn = new SignIn(null);
    }
}
