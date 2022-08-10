package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * This class is the homepage for normal user, calling different classes depending on the user's selection.
 */
class GuiNormalUser {
//    public static void main(String[] args) {
//        new GuiNormalUser("English");
//    }

    public GuiNormalUser(final String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame(languageGetter.translateto(language).homepageNormalUser());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(10, 1, 10, 0));

        JMenuBar jMenuBar = new JMenuBar();
        JMenu m1 = new JMenu(languageGetter.translateto(language).userInfo());
        JMenu m2 = new JMenu(languageGetter.translateto(language).listen());
        JMenu m3 = new JMenu(languageGetter.translateto(language).notification());
        JMenu m4 = new JMenu(languageGetter.translateto(language).recommend());
        JMenu m5 = new JMenu(languageGetter.translateto(language).admin());
        JMenu m6 = new JMenu(languageGetter.translateto(language).exit());
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.add(m4);
        jMenuBar.add(m5);
        jMenuBar.add(m6);

        JMenuItem m11 = new JMenuItem(languageGetter.translateto(language).checkHistory());
        JMenuItem m12 = new JMenuItem(languageGetter.translateto(language).logout());
        JMenuItem m21 = new JMenuItem(languageGetter.translateto(language).songURL());
        JMenuItem m31 = new JMenuItem(languageGetter.translateto(language).checkNewNotifications());
        JMenuItem m32 = new JMenuItem(languageGetter.translateto(language).checkAllNotifications());
        JMenuItem m41 = new JMenuItem(languageGetter.translateto(language).getRecommendSongs());
        JMenuItem m42 = new JMenuItem(languageGetter.translateto(language).rateASong());
        JMenuItem m43 = new JMenuItem(languageGetter.translateto(language).recommendToUser());
        JMenuItem m51 = new JMenuItem(languageGetter.translateto(language).user());
        m1.add(m11);
        m1.add(m12);
        m2.add(m21);
        m3.add(m31);
        m3.add(m32);
        m5.add(m51);
        m4.add(m41);
        m4.add(m42);
        m4.add(m43);

        //1.User Information
        //go back to GuiHistory page
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory(language);
                frame.dispose();
            }
        });
        //go back to GuiSign page
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign(language);
                frame.dispose();
            }
        });


        //2.Listen
        //go inside the URL page (GuiListen)
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen(language);
                frame.dispose();
            }
        });


        //3.Notification
        //go to GuiNewNotification page
        m31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNewNotification(language);
                frame.dispose();
            }
        });
        //go to GuiAllNotification page
        m32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAllNotification(language);
                frame.dispose();
            }
        });


        //4.Get Recommend Songs
        //go to GuiRecommendSong page
        m41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiGetRecSong(language);
                frame.dispose();
            }
        });
        //go to GuiRateSong page
        m42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRateSong(i, language);
                frame.dispose();
            }
        });
        //go to GuiRecSongtoUser page
        m43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRecSongtoUser(language);
                frame.dispose();
            }
        }); ////////////


        //5.Admin
        //go to GuiChangeUserAdmin page
        m51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiChangeUserAdmin(language);
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