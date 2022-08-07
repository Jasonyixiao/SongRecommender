package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;

class GuiNormalUser {
    private static JMenuBar jMenuBar;
    private static JMenu m1, m2, m3, m4, m5, m6;
    private static JMenuItem m11, m12, m21, m31, m32, m33, m61, m62;

    public GuiNormalUser() {
        JFrame frame = new JFrame("Homepage-NormalUser");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(10, 1, 10, 0));

        jMenuBar = new JMenuBar();
        m1 = new JMenu("User Information");
        m2 = new JMenu("Listen");
        m3 = new JMenu("Notification");
        m4 = new JMenu("Get Recommend");
        m5 = new JMenu("Friend");
        m6 = new JMenu("Admin");

        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.add(m4);
        jMenuBar.add(m5);
        jMenuBar.add(m6);


        //User Information
        m11 = new JMenuItem("Check History");
        m12 = new JMenuItem("Log Out");
        m1.add(m11);
        m1.add(m12);
        //go back to GuiHistory page
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory();
            }
        });
        //go back to GuiSign page
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign();
            }
        });


        //Listen
        m21 = new JMenuItem("url");
        m2.add(m21);
        //go inside the URL page
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen();
            }
        });


        //Notification
        m31 = new JMenuItem("Send Message");
        m32 = new JMenuItem("Check new notifications");
        m33 = new JMenuItem("Check all notifications");
        m3.add(m31);
        m3.add(m32);
        m3.add(m33);
        //go to GuiSendMessage page
        m31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSendMessage();
            }
        });
        //go to GuiNewNotification page
        m32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNewNotification();
            }
        });
        //go to GuiAllNotification page
        m33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAllNotification();
            }
        });

        //Admin
        m61 = new JMenuItem("User");
        m62 = new JMenuItem("Self");
        m6.add(m61);
        m6.add(m62);
        //go to GuiChangeUserAdmin page
        m61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiChangeUserAdmin();
            }
        });
        //go to GuiAdminUser page
        m62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminUser();
            }
        });


        frame.getContentPane().add(BorderLayout.NORTH, jMenuBar);
        frame.add(new JButton("song1"));
        frame.add(new JButton("song2"));
        frame.add(new JButton("song3"));
        frame.add(new JButton("song4"));
        frame.add(new JButton("song5"));
        frame.add(new JButton("song6"));
        frame.add(new JButton("song7"));
        frame.add(new JButton("song8"));
        frame.add(new JButton("song9"));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiNormalUser();
    }
}