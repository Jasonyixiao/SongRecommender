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
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel);

        // Add a menu bar and add back menus to it:
        JMenuBar jMenuBar = new JMenuBar();
        JMenu backMenu = new JMenu(languageGetter.translateTo(language).back());
        JMenu Menu = new JMenu(languageGetter.translateTo(language).back());
        JMenu enu = new JMenu(languageGetter.translateTo(language).back());
        JMenuItem item = new JMenuItem(languageGetter.translateTo(language).back());
        jMenuBar.add(backMenu);
        jMenuBar.add(Menu);
        jMenuBar.add(enu);
        backMenu.add(item);

        //put scrollable panel inside JFrame:
        panel.add(jMenuBar);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

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
