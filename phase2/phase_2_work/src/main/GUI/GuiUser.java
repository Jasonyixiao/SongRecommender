package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the users.
 */
public class GuiUser {
    public static void main(String[] args) {
        new GuiUser("English");
    }
    public GuiUser(String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateto(language).user());
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton("User1")); // replace "User1" ...  with usernames
        frame.add(new JButton("User2")); // TODO replace this with a for loop after we connect to controller
        frame.add(new JButton("User3"));
        frame.add(new JButton("User4"));
        frame.add(new JButton("User5"));
        frame.add(new JButton("User6"));
        frame.add(new JButton("User7"));
        frame.add(new JButton("User8"));
        frame.add(new JButton("User9"));
        frame.add(new JButton("User10"));
        frame.setVisible(true);

    }

}
