package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JFrame.*;

class GuiNormalUser {
    public static void main(String[] args) {
        new GuiNormalUser();
    }
    private static JMenuBar jMenuBar;
    private static JMenu m1, m2, m3, m4, m5, m6;
    private static JMenuItem m11, m12, m21, m31, m32, m41, m42, m43, m51, m52;

    public GuiNormalUser() {
        final JFrame frame = new JFrame("Homepage-NormalUser");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(10, 1, 10, 0));

        jMenuBar = new JMenuBar();
        m1 = new JMenu("User Information");
        m2 = new JMenu("Listen");
        m3 = new JMenu("Notification");
        m4 = new JMenu("Recommend");
        m5 = new JMenu("Admin");
        m6 = new JMenu("Exit");
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.add(m4);
        jMenuBar.add(m5);
        jMenuBar.add(m6);

        m11 = new JMenuItem("Check History");
        m12 = new JMenuItem("Log Out");
        m21 = new JMenuItem("url");
        m31 = new JMenuItem("Check new notifications");
        m32 = new JMenuItem("Check all notifications");
        m41 = new JMenuItem("Get Recommend Songs");
        m42 = new JMenuItem("Rate a Song");
        m43 = new JMenuItem("Recommend to User");
        m51 = new JMenuItem("User");
        m52 = new JMenuItem("Self"); //TODO delete this line
        m1.add(m11);
        m1.add(m12);
        m2.add(m21);
        m3.add(m31);
        m3.add(m32);
        m5.add(m51);
        m5.add(m52);
        m4.add(m41);
        m4.add(m42);
        m4.add(m43);

        //1.User Information
        //go back to GuiHistory page
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory();
                frame.dispose();
            }
        });
        //go back to GuiSign page
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign();
                frame.dispose();
            }
        });


        //2.Listen
        //go inside the URL page (GuiListen)
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen();
                frame.dispose();
            }
        });


        //3.Notification
        //go to GuiNewNotification page
        m31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNewNotification();
                frame.dispose();
            }
        });
        //go to GuiAllNotification page
        m32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAllNotification();
                frame.dispose();
            }
        });


        //4.Get Recommend Songs
        //go to GuiRecommendSong page
        m41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiGetRecSong();
                frame.dispose();
            }
        });
        //go to GuiRateSong page
        m42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRateSong(i);
                frame.dispose();
            }
        });
        //go to GuiRecSongtoUser page
        m43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRecSongtoUser();
                frame.dispose();
            }
        }); ////////////


        //5.Admin
        //go to GuiChangeUserAdmin page
        m51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiChangeUserAdmin();
                frame.dispose();
            }
        });
        //go to GuiAdminUser page
        m52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminUser();
                frame.dispose();
            }
        });


        //6.Exit
        m6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                frame.dispose();
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

    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}