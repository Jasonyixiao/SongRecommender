package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;


public class GuiAdminUser {

//    public static void main(String[] args) {
//        new GuiAdminUser("English");
//    } // set default to english

    public GuiAdminUser(final String language, final ShellState shell) { // add parameter
        final LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).homepageAdminUser());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(10, 1, 10, 0));

        JMenuBar jMenuBar = new JMenuBar();
        JMenu m1 = new JMenu(languageGetter.translateTo(language).userInfo()); //return "user information" in chinese
        JMenu m2 = new JMenu(languageGetter.translateTo(language).listen());
        JMenu m3 = new JMenu(languageGetter.translateTo(language).notification());
        JMenu m4 = new JMenu(languageGetter.translateTo(language).recommend());
        JMenu m5 = new JMenu(languageGetter.translateTo(language).admin());
        JMenu m6 = new JMenu(languageGetter.translateTo(language).other());
        JMenuItem m7 = new JMenu(languageGetter.translateTo(language).exit());
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.add(m3);
        jMenuBar.add(m4);
        jMenuBar.add(m5);
        jMenuBar.add(m6);
        jMenuBar.add(m7);


        JMenuItem m11 = new JMenuItem(languageGetter.translateTo(language).checkHistory());
        JMenuItem m12 = new JMenuItem(languageGetter.translateTo(language).logout());
        JMenuItem m21 = new JMenuItem(languageGetter.translateTo(language).songURL());
        JMenuItem m31 = new JMenuItem(languageGetter.translateTo(language).checkNewNotifications());
        JMenuItem m32 = new JMenuItem(languageGetter.translateTo(language).checkAllNotifications());
        JMenuItem m41 = new JMenuItem(languageGetter.translateTo(language).getRecommendSongs());
        JMenuItem m42 = new JMenuItem(languageGetter.translateTo(language).rateASong());
        JMenuItem m43 = new JMenuItem(languageGetter.translateTo(language).recommendToUser());
        JMenuItem m51 = new JMenuItem(languageGetter.translateTo(language).user());
        JMenuItem m61 = new JMenuItem(languageGetter.translateTo(language).ban());
        JMenuItem m62 = new JMenuItem(languageGetter.translateTo(language).delete());
        m1.add(m11);
        m1.add(m12);
        m2.add(m21);
        m3.add(m31);
        m3.add(m32);
        m4.add(m41);
        m4.add(m42);
        m4.add(m43);
        m5.add(m51);
        m6.add(m61);
        m6.add(m62);

        frame.getContentPane().add(BorderLayout.NORTH, jMenuBar);
        frame.add(new JButton("song1")); // we don't need this we will change this to song name, no need to translate
        frame.add(new JButton("song2")); // TODO connect this to the controller and replace this with a for loop
        frame.add(new JButton("song3"));
        frame.add(new JButton("song4"));
        frame.add(new JButton("song5"));
        frame.add(new JButton("song6"));
        frame.add(new JButton("song7"));
        frame.add(new JButton("song8"));
        frame.add(new JButton("song9"));
        frame.setVisible(true);

        //1. Information
        //go back to GuiHistory page
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory(language, shell);
                frame.dispose();
            }
        });
        //go back to GuiSign page
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign(language, shell);
                frame.dispose();
            }
        });

        //2. Listen
        //go inside the URL page (GuiListen)
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen(language,shell);
                frame.dispose();
            }
        });

        //3. Notification
        //go to GuiNewNotification page
        m31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNotification(languageGetter.translateTo(language).checkNewNotifications(),language,shell);
                frame.dispose();
            }
        });
        //go to GuiAllNotification page
        m32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNotification(languageGetter.translateTo(language).checkAllNotifications(),language,shell);
                frame.dispose();
            }
        });

        //4. Get Recommend Songs
        //go to GuiRecommendSong page
        m41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiGetRecSong(language,shell);
                frame.dispose();
            }
        });
        //go to GuiRateSong page
        m42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRateSong(language, shell);
                frame.dispose();
            }
        });
        //go to GuiRecSongtoUser page
        m43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRecSongtoUser(language,shell);
                frame.dispose();
            }
        }); //////////


        //5. Admin
        //go to GuiChangeUserAdmin page
        m51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiChangeUserAdmin(language);
                frame.dispose();
            }
        });


        //6. Others
        //go to GuiBan page
        m61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiBan(language);
                frame.dispose();
            }
        });
        //go to GuiDelete page
        m62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiDelete(language);
                frame.dispose();
            }
        });

        //7. Exit
        m7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}

