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
        frame.setLayout(new GridLayout(11, 1));

        //Add a scrollable panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 8));
        frame.add(panel);
        JMenuItem jMenuItem = new JMenuItem(languageGetter.translateTo(language).back());
        panel.add(jMenuItem);

        //Add history to panel
        for(int i = 0; i < 10 & i < shell.getLoginController().getUserController().
                getLogInHistory(shell.getUserProfile().getUsername()).size(); i++){
            String history = shell.getLoginController().getUserController().
                    getLogInHistory(shell.getUserProfile().getUsername()).get(i);
            frame.add(new JButton(history));
        }

        frame.setVisible(true);

        jMenuItem.addActionListener(new ActionListener() {
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
