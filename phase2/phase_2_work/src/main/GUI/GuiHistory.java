package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents login history.
 */
public class GuiHistory {
    public GuiHistory(final String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateto(language).LoginHistory());
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton("Login History1:")); // get rid of "login History 1"... just put 1, 2, 3 instead
        frame.add(new JButton("Login History2:")); // or use a for loop
        frame.add(new JButton("Login History3:")); // TODO connnect this to the controller
        frame.setVisible(true);
        JButton button2 = new JButton(languageGetter.translateto(language).back());
        button2.setBounds(400,10,80,25);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminUser(language); // here we need to add a if statement to check if the current user is normal user or admin user
                frame.dispose();
            }
        });

    }
    public static void main(String[] args) {
        new GuiHistory("English");
    }
}
