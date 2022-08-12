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
        final LanguageFactory languageFactory = new LanguageFactory();
        final JFrame frame = new JFrame(languageFactory.translateTo(language).homepageAdminUser());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));


        // Add a menu bar and add dropdown menus to it:
        JMenuBar jMenuBar = new JMenuBar();

        JMenu userInfoMenu = new JMenu(languageFactory.translateTo(language).userInfo()); //return "user information" in chinese
        JMenu notificationMenu = new JMenu(languageFactory.translateTo(language).notification());
        JMenu recommendMenu = new JMenu(languageFactory.translateTo(language).recommend());
        JMenu adminMenu = new JMenu(languageFactory.translateTo(language).admin());

        JMenu logoutMenu = new JMenu(languageFactory.translateTo(language).logout());
        JMenu recommendStrategy = new JMenu(languageFactory.translateTo(language).recommendStrategy());

        jMenuBar.add(userInfoMenu);
        jMenuBar.add(notificationMenu);
        jMenuBar.add(recommendMenu);
        jMenuBar.add(adminMenu);
        jMenuBar.add(recommendStrategy);

        jMenuBar.add(logoutMenu);

        // Add items to the dropdown menu:
        JMenuItem checkHistoryButton = new JMenuItem(languageFactory.translateTo(language).checkHistory());
        JMenuItem logoutButton = new JMenuItem(languageFactory.translateTo(language).logout());
        JMenuItem checkAllNotificationButton = new JMenuItem(languageFactory.translateTo(language).checkAllNotifications());

        JMenuItem rateSongButton = new JMenuItem(languageFactory.translateTo(language).rateASong());
        JMenuItem recommendToUserButton = new JMenuItem(languageFactory.translateTo(language).recommendToUser());
        JMenuItem promoteButton = new JMenuItem(languageFactory.translateTo(language).promote());
        JMenuItem banButton = new JMenuItem(languageFactory.translateTo(language).ban());
        JMenuItem deleteButton = new JMenuItem(languageFactory.translateTo(language).delete());
        JMenuItem recommendByRating = new JMenuItem(languageFactory.translateTo(language).recommendByAvgRating());

        userInfoMenu.add(checkHistoryButton);
        logoutMenu.add(logoutButton);
        recommendStrategy.add(recommendByRating);
        notificationMenu.add(checkAllNotificationButton);

        recommendMenu.add(rateSongButton);
        recommendMenu.add(recommendToUserButton);
        adminMenu.add(promoteButton);
        adminMenu.add(banButton);
        adminMenu.add(deleteButton);

        // add menubar to panel and makes the panel scrollable:
        panel.add(jMenuBar);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add top Nine songs:
        IRecommender recommender = new RecommendByAvgRating();
        for (final String song: shell.getSongController().getRecommend(recommender)){
            JButton songButton = new JButton(song +
                    "  " + languageFactory.translateTo(language).author() + ": " +
                    shell.getSongController().getSongAuthor(song) +
                    "  " + languageFactory.translateTo(language).rating() + ": " +
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

        //Add action to Recommend by avg rating button
        recommendByRating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRecByAvgRate(shell, language);
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


        //3. Notification

        //go to GuiAllNotification page
        checkAllNotificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNotification(language, shell);
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
        promoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminTasks(language,"promote", shell);
                frame.dispose();
            }
        });


        //6. Others
        //go to GuiBan page
        banButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminTasks(language,"ban", shell);
                frame.dispose();
            }
        });
        //go to GuiDelete page
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminTasks(language,"delete", shell);
                frame.dispose();
            }
        });
    }

}

