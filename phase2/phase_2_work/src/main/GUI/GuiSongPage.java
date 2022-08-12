package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSongPage {
    public GuiSongPage(final String language, final ShellState shell, final String songName){ // add: ShellState shell,
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame();
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(1, 1));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        //Add the back button
        JButton backButton = new JButton(languageGetter.translateTo(language).back());
        panel.add(backButton);
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

        //Add song name + author
        final JLabel song = new JLabel(languageGetter.translateTo(language).songName()+ ": " +
                songName + "     " +
                languageGetter.translateTo(language).author() + ": "+
                shell.getSongController().getSongAuthor(songName));

        JButton listenButton = new JButton(languageGetter.translateTo(language).listen());
        JButton rateButton = new JButton(languageGetter.translateTo(language).rate());

        //Add actionlistener to listenButton
        listenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String songurl = shell.getSongController().listen(songName);;
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(songurl));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        //Add rate button
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRateOutOf5(language, shell, songName);
                frame.dispose();
            }
        });
        panel.add(song);
        panel.add(listenButton);
        panel.add(rateButton);
        frame.add(panel);

        frame.setVisible(true);
    }

}
