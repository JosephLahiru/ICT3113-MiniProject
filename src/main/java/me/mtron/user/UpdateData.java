package me.mtron.user;

import me.mtron.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class UpdateData extends JFrame{
    private JPanel panel1;
    private JTextField tfUserName;
    private JTextField tfNickName;
    private JTextField tfProPic;
    private JPasswordField pwdField;
    private JPasswordField pwdComField;
    private JButton clearButton;
    private JButton submitButton;
    private JButton loadDataButton;
    private String email;

    public UpdateData(String email) {
        this.email = email;

        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

                session.beginTransaction();

                String hql = "FROM User WHERE email = :email";
                Query<User> query = session.createQuery(hql, User.class);
                query.setParameter("email", email);

                User u = query.uniqueResult();

                tfUserName.setText(u.getUserName());
                tfNickName.setText(u.getNickname());
                tfProPic.setText(u.getProfilePicture());

                session.getTransaction().commit();
                session.close();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

                session.beginTransaction();

                Query<User> query = session.createQuery("UPDATE User SET userName = :newUserName, nickname = :newNickName, profilePicture=:newProPic, password=:newPwd WHERE email = :email");
                query.setParameter("email", email);
                query.setParameter("newUserName", tfUserName.getText());
                query.setParameter("newNickName", tfNickName.getText());
                query.setParameter("newProPic", tfProPic.getText());

                if(Objects.equals(Arrays.toString(pwdField.getPassword()), Arrays.toString(pwdComField.getPassword()))){
                    query.setParameter("newPwd", Arrays.toString(pwdField.getPassword()));
                }else{
                    JOptionPane.showMessageDialog(null, "Password and Password Confirmation does not match!!!");
                    pwdField.setText("");
                    pwdComField.setText("");
                }

                int rowsUpdated = query.executeUpdate();

                if (rowsUpdated > 0) {
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Fields updated Successfully!!!");
                    clearForm();
                } else {
                    session.getTransaction().rollback();
                }
                session.close();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }

    private void clearForm(){
        tfUserName.setText("");
        tfNickName.setText("");
        tfProPic.setText("");
        pwdField.setText("");
        pwdComField.setText("");
    }
}
