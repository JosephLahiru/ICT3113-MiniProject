package me.mtron.admin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.intellij.uiDesigner.core.*;

public class AddUsersChat extends JFrame, JPanel {
    private JPanel subscribeUserPanel;

    public AddUsersChat() {
        initComponents();
        super("Add Users to Chat");
        this.setContentPane(subscribeUserPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        sHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUsersChat.this.dispose();
                new Dashboard();
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        var panel1 = new JPanel();
        var panel2 = new JPanel();
        var label1 = new JLabel();
        var hSpacer1 = new Spacer();
        var hSpacer2 = new Spacer();
        sHomeButton = new JButton();
        var scrollPane1 = new JScrollPane();
        var panel3 = new JPanel();
        table2 = new JTable();
        var label2 = new JLabel();
        table1 = new JTable();
        var label3 = new JLabel();
        var label4 = new JLabel();
        sSUNTextField = new JTextField();
        var label5 = new JLabel();
        sSUDETextField = new JTextField();
        sSUSearchButton = new JButton();
        button2 = new JButton();
        var hSpacer3 = new Spacer();
        sSCResetButton = new JButton();
        sSCSearchButton = new JButton();
        sSCNTextField = new JTextField();
        sSCDITextField = new JTextField();
        var hSpacer4 = new Spacer();
        var vSpacer1 = new Spacer();
        var vSpacer2 = new Spacer();
        var vSpacer3 = new Spacer();
        var vSpacer4 = new Spacer();
        var vSpacer5 = new Spacer();
        var vSpacer6 = new Spacer();
        var vSpacer7 = new Spacer();
        var vSpacer8 = new Spacer();
        var vSpacer9 = new Spacer();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException
        ();}});
        setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));

            //======== panel2 ========
            {
                panel2.setAlignmentX(0.0F);
                panel2.setAlignmentY(0.0F);
                panel2.setEnabled(false);
                panel2.setRequestFocusEnabled(false);
                panel2.setVerifyInputWhenFocusTarget(false);
                panel2.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), 0, 0));

                //---- label1 ----
                label1.setAlignmentY(0.0F);
                label1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_Add_Male_User_Group_100px.png")));
                label1.setText("Subscribe Users To Chats");
                panel2.add(label1, new GridConstraints(0, 2, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
                panel2.add(hSpacer1, new GridConstraints(0, 3, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));
                panel2.add(hSpacer2, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));

                //---- sHomeButton ----
                sHomeButton.setBorderPainted(false);
                sHomeButton.setContentAreaFilled(false);
                sHomeButton.setDefaultCapable(true);
                sHomeButton.setFocusPainted(false);
                sHomeButton.setIcon(new ImageIcon(getClass().getResource("/images/icons8_home_100px.png")));
                sHomeButton.setRequestFocusEnabled(false);
                sHomeButton.setText("");
                panel2.add(sHomeButton, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
            }
            panel1.add(panel2, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_FIXED,
                GridConstraints.SIZEPOLICY_FIXED,
                new Dimension(1280, 100), new Dimension(1280, 100), new Dimension(1280, 100)));

            //======== scrollPane1 ========
            {

                //======== panel3 ========
                {
                    panel3.setAlignmentX(0.0F);
                    panel3.setAlignmentY(0.0F);
                    panel3.setLayout(new GridLayoutManager(20, 5, new Insets(30, 30, 30, 30), 0, 0));
                    panel3.add(table2, new GridConstraints(19, 4, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null));

                    //---- label2 ----
                    label2.setText("Chat Table");
                    panel3.add(label2, new GridConstraints(18, 4, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(table1, new GridConstraints(2, 4, 15, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null));

                    //---- label3 ----
                    label3.setText("User Table");
                    panel3.add(label3, new GridConstraints(0, 4, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, new Dimension(56, 17), null));

                    //---- label4 ----
                    label4.setText("Search User");
                    panel3.add(label4, new GridConstraints(2, 0, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(sSUNTextField, new GridConstraints(4, 0, 1, 3,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));

                    //---- label5 ----
                    label5.setText("Search Chat");
                    panel3.add(label5, new GridConstraints(10, 0, 1, 3,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(sSUDETextField, new GridConstraints(12, 0, 1, 3,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));

                    //---- sSUSearchButton ----
                    sSUSearchButton.setText("Button");
                    panel3.add(sSUSearchButton, new GridConstraints(8, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));

                    //---- button2 ----
                    button2.setText("Button");
                    panel3.add(button2, new GridConstraints(16, 2, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(hSpacer3, new GridConstraints(4, 3, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        null, null, null));

                    //---- sSCResetButton ----
                    sSCResetButton.setText("Button");
                    panel3.add(sSCResetButton, new GridConstraints(8, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));

                    //---- sSCSearchButton ----
                    sSCSearchButton.setText("Button");
                    panel3.add(sSCSearchButton, new GridConstraints(16, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(sSCNTextField, new GridConstraints(6, 0, 1, 3,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(sSCDITextField, new GridConstraints(14, 0, 1, 3,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(hSpacer4, new GridConstraints(8, 1, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_FIXED,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        null, null, null));
                    panel3.add(vSpacer1, new GridConstraints(3, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer2, new GridConstraints(5, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer3, new GridConstraints(7, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer4, new GridConstraints(9, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer5, new GridConstraints(11, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer6, new GridConstraints(13, 0, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer7, new GridConstraints(15, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                    panel3.add(vSpacer8, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        null, null, null));
                    panel3.add(vSpacer9, new GridConstraints(17, 4, 1, 1,
                        GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_VERTICAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                }
                scrollPane1.setViewportView(panel3);
            }
            panel1.add(scrollPane1, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));
        }
        add(panel1, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(1280, 720), new Dimension(1280, 720), new Dimension(1280, 720)));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton sHomeButton;
    private JTable table2;
    private JTable table1;
    private JTextField sSUNTextField;
    private JTextField sSUDETextField;
    private JButton sSUSearchButton;
    private JButton button2;
    private JButton sSCResetButton;
    private JButton sSCSearchButton;
    private JTextField sSCNTextField;
    private JTextField sSCDITextField;
    private JTextField textField5;
    private JTextField textField6;
    private JButton resetButton;
    private JButton subscribeButton;
    private JButton sSUResetButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
