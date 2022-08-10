package GUI;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiNotification {
    public GuiNotification(String notificationType, String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateto(language).notification());
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));
        frame.add(new JButton(notificationType));

        frame.setVisible(true);

    }

}
