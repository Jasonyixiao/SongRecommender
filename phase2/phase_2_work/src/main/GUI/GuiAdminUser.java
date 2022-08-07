package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;
public class GuiAdminUser {

    private static JMenuBar jMenuBar;
    private static JMenu m1, m2, m3, m4, m5, m6, m7;
    private static JMenuItem m11, m12, m21, m31, m32, m41, m42, m43, m51, m61, m62;

    public GuiAdminUser() {
        JFrame frame = new JFrame("Homepage-Admin User");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(10, 1, 10, 0));

        jMenuBar = new JMenuBar();
        m1 = new JMenu("User Information");
        m2 = new JMenu("Listen");
        m3 = new JMenu("Notification");
        m4 = new JMenu("Recommend");
        m5 = new JMenu("Admin");
        m6 = new JMenu("Other");
        m7 = new JMenu("Exit");
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.add(m4);
        jMenuBar.add(m5);
        jMenuBar.add(m6);
        jMenuBar.add(m7);


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
        //go inside the URL page (GuiListen)
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen();
            }
        });

        //Notification
        m31 = new JMenuItem("Check new notifications");
        m32 = new JMenuItem("Check all notifications");
        m3.add(m31);
        m3.add(m32);
        //go to GuiNewNotification page
        m31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNewNotification();
            }
        });
        //go to GuiAllNotification page
        m32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAllNotification();
            }
        });


        //Get Recommend Songs
        m41 = new JMenuItem("Get Recommend Songs");
        m42 = new JMenuItem("Rate a Song");
        m43 = new JMenuItem("Recommend to User");
        m4.add(m41);
        m4.add(m42);
        m4.add(m43);
        //go to GuiRecommendSong page
        m41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiGetRecSong();
            }
        });
        //go to GuiRateSong page
        m42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRateSong(i);
            }
        });
        //go to GuiRecSongtoUser page
        m43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRecSongtoUser();
            }
        }); //////////


        //Admin
        m51 = new JMenuItem("User");
        m5.add(m51);
        //go to GuiChangeUserAdmin page
        m51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiChangeUserAdmin();
            }
        });


        //Others
        m61 = new JMenuItem("Ban");
        m62 = new JMenuItem("Delete");
        m6.add(m61);
        m6.add(m62);
        //go to GuiBan page
        m61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiBan();
            }
        });
        //go to GuiDelete page
        m62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiDelete();
            }
        });


        //Exit
        // haven't finished yet


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
        new GuiAdminUser();
    }

}
