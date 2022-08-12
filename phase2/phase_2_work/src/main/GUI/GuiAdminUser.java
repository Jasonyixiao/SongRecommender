package GUI;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import recommendStrategy.IRecommender;
import recommendStrategy.RecommendByAvgRating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JFrame.*;

/**
 *  This class is the homepage for Admin User, calling different classes depending on the user's selection.
 */
public class GuiAdminUser {


    public GuiAdminUser(final String language, final ShellState shell) {
        final LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).homepageAdminUser());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));


        // Add a menu bar and add dropdown menus to it:
        JMenuBar jMenuBar = new JMenuBar();

        JMenu userInfoMenu = new JMenu(languageGetter.translateTo(language).userInfo()); //return "user information" in chinese
        JMenu listenMenu = new JMenu(languageGetter.translateTo(language).listen());
        JMenu notificationMenu = new JMenu(languageGetter.translateTo(language).notification());
        JMenu recommendMenu = new JMenu(languageGetter.translateTo(language).recommend());
        JMenu adminMenu = new JMenu(languageGetter.translateTo(language).admin());
        JMenu otherMenu = new JMenu(languageGetter.translateTo(language).other());
        JMenu logoutMenu = new JMenu(languageGetter.translateTo(language).logout());

        jMenuBar.add(userInfoMenu);
        jMenuBar.add(listenMenu);
        jMenuBar.add(notificationMenu);
        jMenuBar.add(recommendMenu);
        jMenuBar.add(adminMenu);
        jMenuBar.add(otherMenu);
        jMenuBar.add(logoutMenu);

        // Add items to the dropdown menu:
        JMenuItem checkHistoryButton = new JMenuItem(languageGetter.translateTo(language).checkHistory());
        JMenuItem logoutButton = new JMenuItem(languageGetter.translateTo(language).logout());
        JMenuItem songNameButton = new JMenuItem(languageGetter.translateTo(language).songName());
        JMenuItem checkAllNotificationButton = new JMenuItem(languageGetter.translateTo(language).checkAllNotifications());
        JMenuItem getRecommendSongsButton = new JMenuItem(languageGetter.translateTo(language).getRecommendSongs());
        JMenuItem rateSongButton = new JMenuItem(languageGetter.translateTo(language).rateASong());
        JMenuItem recommendToUserButton = new JMenuItem(languageGetter.translateTo(language).recommendToUser());
        JMenuItem userButton = new JMenuItem(languageGetter.translateTo(language).user());
        JMenuItem banButton = new JMenuItem(languageGetter.translateTo(language).ban());
        JMenuItem deleteButton = new JMenuItem(languageGetter.translateTo(language).delete());

        userInfoMenu.add(checkHistoryButton);
        logoutMenu.add(logoutButton);
//        listenMenu.add(songUrlButton);
        notificationMenu.add(checkAllNotificationButton);
        recommendMenu.add(getRecommendSongsButton);
        recommendMenu.add(rateSongButton);
        recommendMenu.add(recommendToUserButton);
        adminMenu.add(userButton);
        otherMenu.add(banButton);
        otherMenu.add(deleteButton);

        // add menubar to panel and makes the panel scrollable:
        panel.add(jMenuBar);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add top Nine songs:
        IRecommender recommender = new RecommendByAvgRating();
        for (final String song: shell.getSongController().getRecommend(recommender)){
            JButton songButton = new JButton(song +
                    "  Author: " +
                    shell.getSongController().getSongAuthor(song) +
                    "  rating: " +
                    shell.getSongController().getRatting(song));

            panel.add(songButton);
            songButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GuiSongPage(language, shell, song);
                    frame.dispose();
                }
            });
        }

        frame.setVisible(true);

        //1. Information
        //go to GuiHistory page
        checkHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory(language, shell);
                frame.dispose();
            }
        });
        //Log out and go back to GuiSign page
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{UserController userController = shell.getLoginController().getUserController();
                LoginController loginController = new LoginController(userController);
                loginController.LogOff(shell.getUserProfile());
                userController.saveUserData();
                shell.getSongController().saveSongData();
                shell.getNotificationController().saveNotificationData();
                new GuiSign(language, shell);
                frame.dispose();}
                catch (IOException exception){
                    new GuiErrorPage(language, shell);
                    frame.dispose();
                }
            }
        });

        //2. Listen
        //go inside the URL page (GuiListen)
        songNameButton.addActionListener(new ActionListener() {
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

        //4. Get Recommend Songs
        //go to GuiRecommendSong page
        getRecommendSongsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiGetRecSong(language,shell);
                frame.dispose();
            }
        });
        //go to GuiRateSong page
        rateSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRateSong(language, shell);
                frame.dispose();
            }
        });
        //go to GuiRecSongtoUser page
        recommendToUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRecSongToUser(language,shell);
                frame.dispose();
            }
        }); //////////


        //5. Admin
        //go to GuiPromoteUserToAdmin page
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiPromoteUserToAdmin(language);
                frame.dispose();
            }
        });


        //6. Others
        //go to GuiBan page
        banButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiBan(language);
                frame.dispose();
            }
        });
        //go to GuiDelete page
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiDelete(language);
                frame.dispose();
            }
        });
    }

}

