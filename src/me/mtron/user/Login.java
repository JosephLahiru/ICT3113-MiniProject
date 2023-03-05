package me.mtron.user;

//public class Login {
//}

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1;
    JPasswordField pf;
    JButton b;
    JPanel p1, p2;

    Login() {
        setTitle("Login Form");
        l1 = new JLabel("Username:");
        l2 = new JLabel("Password:");
        tf1 = new JTextField(20);
        pf = new JPasswordField(20);
        b = new JButton("Login");
        b.addActionListener(this);

        p1 = new JPanel(new GridLayout(2, 1));
        p1.add(l1);
        p1.add(l2);

        p2 = new JPanel(new GridLayout(2, 1));
        p2.add(tf1);
        p2.add(pf);

        add(p1, BorderLayout.WEST);
        add(p2, BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = tf1.getText();
        String password = new String(pf.getPassword());
        if (username.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login successful");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
