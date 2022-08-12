package GUI;

import controllers.ShellState;
import recommendStrategy.IRecommender;
import recommendStrategy.RecommendByAvgRating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiRecByAvgRate {
    GuiRecByAvgRate(final ShellState shell, final String language) { //ShellState shell,

    LanguageGetter languageGetter = new LanguageGetter();
    final JFrame frame = new JFrame(languageGetter.translateTo(language).recommendByAvgRating());
    frame.setLayout(new GridLayout(11, 1));
    JMenuBar bar = new JMenuBar();
    JMenu backMenu = new JMenu(languageGetter.translateTo(language).back());
    JMenuItem backButton = new JMenuItem(languageGetter.translateTo(language).back());
    backMenu.add(backButton);
    bar.add(backMenu);
    frame.add(bar);
    frame.setSize(700, 700);
    frame.setVisible(true);

    // Add top Nine songs by rating by default:
        IRecommender recommender = new RecommendByAvgRating();
        for (final String song: shell.getSongController().getRecommend(recommender)) {
            JButton songButton = new JButton(song +
                    "  " + languageGetter.translateTo(language).author() + ": " +
                    shell.getSongController().getSongAuthor(song) +
                    "  " + languageGetter.translateTo(language).rating() + ": " +
                    shell.getSongController().getRatting(song));
            frame.add(songButton);
            songButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GuiSongPage(language, shell, song);
                    frame.dispose();
                }
            });
        }

        // add action to the back button:
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentUsername = shell.getUserProfile().getUsername();
                if (shell.getLoginController().getUserController().isAdmin(currentUsername)){
                    new GuiAdminUser(language,shell);
                    frame.dispose();
                }else{
                    new GuiNormalUser(language, shell);
                    frame.dispose();
                }
            }
        });


    }
}
