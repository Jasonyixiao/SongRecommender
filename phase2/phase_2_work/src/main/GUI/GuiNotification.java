package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiNotification {
//    public static void main(String[] args) {
//        new GuiNotification("allnotification", "English");
//    }
    public GuiNotification(String notificationType, final String language, final ShellState shell) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateTo(language).notification());
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        button2.setBounds(400,10,80,25);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminUser(language,shell); // here we need to add a if statement to check if the current user is normal user or admin user
                frame.dispose();
            }
        });

        frame.setVisible(true);

    }

}
