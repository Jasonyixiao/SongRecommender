package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents login history.
 */
public class GuiHistory {
    public GuiHistory(final String language, final ShellState shell) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).LoginHistory());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        //Add a scrollable panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        JButton item = new JButton(languageGetter.translateTo(language).back());
        panel.add(item);

        // Add a menu bar and add back menus to it:

        //put scrollable panel inside JFrame:

        //Add history to panel
        for(String history: shell.getLoginController().getUserController().
                getLogInHistory(shell.getUserProfile().getUsername())){

            panel.add(new JButton(history));
        }

        frame.setVisible(true);

        item.addActionListener(new ActionListener() {
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
//    public static void main(String[] args) {
//        new GuiHistory("English");
//    }
}
