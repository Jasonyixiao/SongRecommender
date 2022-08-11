package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class shows the user the recommended songs.
 */
public class GuiGetRecSong {

    public GuiGetRecSong(final String language, final ShellState shell) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).recommendSongs());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        JPanel panel = new JPanel();

        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        panel.add(button2);

        button2.addActionListener(new ActionListener() {
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
        
        frame.setVisible(true);

    }

}
