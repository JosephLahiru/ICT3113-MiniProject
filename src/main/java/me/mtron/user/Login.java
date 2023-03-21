package me.mtron.user;

import me.mtron.db.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class Login extends JFrame{

    private JLabel imageLabel;
    private JTextField tfEmail;
    private JPasswordField pwdField;
    private JButton clearButton;
    private JButton loginButton;
    private JPanel loginPanel;
    private String email;
    private String password;

    public Login(JFrame parent) {
        super("Login");

        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfEmail.setText("");
                pwdField.setText("");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = tfEmail.getText();
                password = String.valueOf(pwdField.getPassword());

                Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

                session.beginTransaction();

                List<User> users = session.createQuery("select u from User u", User.class).list();

                for (User u: users) {
                    if(Objects.equals(u.getEmail(), email) && Objects.equals(u.getPassword(), password)){
                        System.out.println("Welcome " + u.getNickname());
                        Login.this.dispose();
                        new Dashboard(u.getEmail(), u.getNickname(), u.getProfilePicture());
                    }
//                    System.out.println("Email: " + u.getEmail());
//                    System.out.println("Password: " + u.getPassword());
                }

                session.getTransaction().commit();
                session.close();

            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login(null);
    }
}
