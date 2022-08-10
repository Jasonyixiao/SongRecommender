package GUI;

import javax.swing.*;
/**
 * This class represents the finding user page.
 */
public class GuiFindUser {

    public GuiFindUser(String title, String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(title);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label = new JLabel(languageGetter.translateto(language).userName());
        label.setBounds(10, 20, 80, 25);

        JTextField userName = new JTextField();
        userName.setBounds(100, 20, 165, 25);

        JButton button = new JButton(languageGetter.translateto(language).search());
        button.setBounds(10, 80, 80, 25);

        panel.add(label);
        panel.add(userName);
        panel.add(button);
        frame.setVisible(true);
    }
}
