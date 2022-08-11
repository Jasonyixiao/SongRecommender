package GUI;

import controllers.ShellState;
import recommendStrategy.IRecommender;
import recommendStrategy.RecommendByAvgRating;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * This class is the homepage for normal user, calling different classes depending on the user's selection.
 */
class GuiNormalUser {
//    public static void main(String[] args) {
//        new GuiNormalUser("English");
//    }

    public GuiNormalUser(final String language, final ShellState shell) {
        final LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).homepageNormalUser());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // Add a menu bar and add dropdown menus to it:
        JMenuBar jMenuBar = new JMenuBar();
        JMenu userInfoMenu = new JMenu(languageGetter.translateTo(language).userInfo());
        JMenu listenMenu = new JMenu(languageGetter.translateTo(language).listen());
        JMenu notificationMenu = new JMenu(languageGetter.translateTo(language).notification());
        JMenu recommendMenu = new JMenu(languageGetter.translateTo(language).recommend());
        JMenu exitMenu = new JMenu(languageGetter.translateTo(language).exit());

        jMenuBar.add(userInfoMenu);
        jMenuBar.add(listenMenu);
        jMenuBar.add(notificationMenu);
        jMenuBar.add(recommendMenu);
        jMenuBar.add(exitMenu);

        // Add items to the dropdown menu:
        JMenuItem checkHisotryMenuButton = new JMenuItem(languageGetter.translateTo(language).checkHistory());
        JMenuItem logoutMenuButton = new JMenuItem(languageGetter.translateTo(language).logout());
        JMenuItem songUrlMenuButton = new JMenuItem(languageGetter.translateTo(language).songURL());
        JMenuItem checkAllNotificationButton = new JMenuItem(languageGetter.translateTo(language).checkAllNotifications());
        JMenuItem getRemommendSongButton = new JMenuItem(languageGetter.translateTo(language).getRecommendSongs());
        JMenuItem rateSongButton = new JMenuItem(languageGetter.translateTo(language).rateASong());
        JMenuItem reommendToUserButton = new JMenuItem(languageGetter.translateTo(language).recommendToUser());

        userInfoMenu.add(checkHisotryMenuButton);
        userInfoMenu.add(logoutMenuButton);
        listenMenu.add(songUrlMenuButton);
        notificationMenu.add(checkAllNotificationButton);
        recommendMenu.add(getRemommendSongButton);
        recommendMenu.add(rateSongButton);
        recommendMenu.add(reommendToUserButton);

        // add menubar to panel and makes the panel scrollable:
        panel.add(jMenuBar);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // Add top Nine songs by rating by default:
        IRecommender recommender = new RecommendByAvgRating();
        for (String song: shell.getSongController().getRecommend(recommender)) {
            JButton songButton = new JButton(song);
            panel.add(songButton);
            songButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GuiGetRecSong(language, shell);
                    frame.dispose();
                }
            });
        }

        //1.User Information
        //go back to GuiHistory page
        checkHisotryMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory(language,shell);
                frame.dispose();
            }
        });
        //go back to GuiSign page
        logoutMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign(language, shell);
                frame.dispose();
            }
        });


        //2.Listen
        //go inside the URL page (GuiListen)
        songUrlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen(language,shell);
                frame.dispose();
            }
        });


        //3. Notification

        //go to GuiAllNotification page
        checkAllNotificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNotification(languageGetter.translateTo(language).checkAllNotifications(),language,shell);
                frame.dispose();
            }
        });

        //4.Get Recommend Songs
        //go to GuiRecommendSong page
        getRemommendSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiGetRecSong(language, shell);
                frame.dispose();
            }
        });
        //go to GuiRateSong page
        rateSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new GuiRateSong(language,shell);
                frame.dispose();
            }
        });
        //go to GuiRecSongtoUser page
        reommendToUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] i = new String[0];
                new GuiRecSongtoUser(language,shell);
                frame.dispose();
            }
        }); ////////////




        //6.Exit
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                frame.dispose();
            }
        });

    }


    /**
     * This method will close the window.
     * @param frame is the current frame of the window.
     */
//    private static void windowClose(Frame frame) {
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // super.windowClosing(e);
//                System.exit(0);
//            }
//        });
//    }
}