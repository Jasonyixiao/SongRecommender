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
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateTo(language).LoginHistory());
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        for(String history: shell.getLoginController().getUserController().
                getLogInHistory(shell.getUserProfile().getUsername())){
            frame.add(new JButton(history));
        }
        frame.setVisible(true);
        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        button2.setBounds(400,10,80,25);
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
                }

            }
        });

    }
//    public static void main(String[] args) {
//        new GuiHistory("English");
//    }
}
