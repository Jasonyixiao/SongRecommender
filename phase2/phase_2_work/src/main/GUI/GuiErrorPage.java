package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This page will show when a user fails to log out.
 */
public class GuiErrorPage {
    GuiErrorPage(final String language, final ShellState shell){
        final JFrame frame = new JFrame("!!!!");
        LanguageFactory languageFactory = new LanguageFactory();
        final JLabel messageLabel = new JLabel();
        JPanel panel = new JPanel();
        messageLabel.setBounds(125,250,250,35);
        panel.add(messageLabel);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));
        messageLabel.setForeground(Color.red);
        messageLabel.setText(languageFactory.translateTo(language).logoutFailed());
        JButton jButton = new JButton(languageFactory.translateTo(language).back());
        jButton.addActionListener(new ActionListener() {
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

