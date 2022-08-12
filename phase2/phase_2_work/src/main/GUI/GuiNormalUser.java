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
        JMenu notificationMenu = new JMenu(languageGetter.translateTo(language).notification());
        JMenu recommendMenu = new JMenu(languageGetter.translateTo(language).recommend());
        JMenu logoutMenu = new JMenu(languageGetter.translateTo(language).logout());
        JMenu recommendBy = new JMenu(languageGetter.translateTo(language).recommendStrategy());


        jMenuBar.add(userInfoMenu);
        jMenuBar.add(notificationMenu);
        jMenuBar.add(recommendMenu);
        jMenuBar.add(recommendBy);
        jMenuBar.add(logoutMenu);



        // Add items to the dropdown menu:
        JMenuItem checkHisotryMenuButton = new JMenuItem(languageGetter.translateTo(language).checkHistory());
        JMenuItem checkAllNotificationButton = new JMenuItem(languageGetter.translateTo(language).checkAllNotifications());
        JMenuItem getRecommendSongButton = new JMenuItem(languageGetter.translateTo(language).getRecommendSongs());
        JMenuItem rateSongButton = new JMenuItem(languageGetter.translateTo(language).rateASong());
        JMenuItem reommendToUserButton = new JMenuItem(languageGetter.translateTo(language).recommendToUser());
        JMenuItem logoutButton = new JMenuItem(languageGetter.translateTo(language).logout());
        JMenuItem recommendByRating = new JMenuItem(languageGetter.translateTo(language).recommendByAvgRating());

        userInfoMenu.add(checkHisotryMenuButton);
        notificationMenu.add(checkAllNotificationButton);
        recommendMenu.add(getRecommendSongButton);
        recommendMenu.add(rateSongButton);
        recommendMenu.add(reommendToUserButton);
        logoutMenu.add(logoutButton);
        recommendBy.add(recommendByRating);



        // add menubar to panel and makes the panel scrollable:
        panel.add(jMenuBar);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // Add top Nine songs by rating by default:
        IRecommender recommender = new RecommendByAvgRating();
        for (final String song: shell.getSongController().getRecommend(recommender)) {
            JButton songButton = new JButton(song +
                    "  " + languageGetter.translateTo(language).author() + ": " +
                    shell.getSongController().getSongAuthor(song) +
                    "  " + languageGetter.translateTo(language).rating() + ": " +
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

        //1.User Information
        //go back to GuiHistory page
        checkHisotryMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiHistory(language,shell);
                frame.dispose();
            }
        });
        //Add action listener to the recommend by rating button
        recommendByRating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRecByAvgRate(shell, language);
            }
        });

        //go back to GuiSign page
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    UserController userController = shell.getLoginController().getUserController();
                    LoginController loginController = new LoginController(userController);
                    loginController.LogOff(shell.getUserProfile());
                    userController.saveUserData();
                    shell.getSongController().saveSongData();
                    shell.getNotificationController().saveNotificationData();
                    new GuiSign(language, shell);
                    frame.dispose();}
                catch (IOException exception) {
                    new GuiErrorPage(language, shell);
                    frame.dispose();
                }
            }
        });



        //2. Notification

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
        getRecommendSongButton.addActionListener(new ActionListener() {
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
                new GuiRecSongToUser(language,shell);
                frame.dispose();
            }
        }); ////////////

    }



}