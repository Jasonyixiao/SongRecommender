package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiGetRecSong {

    public GuiGetRecSong(final String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateto(language).recommendSongs());
        frame.setSize(500, 4000);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
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
        frame.setLayout(new GridLayout(100, 1, 10, 0)); // Todo we need to figure out what happens when we add a lot of songs
        frame.add(new JButton("Song1")); // again we will change "song1".... to the name of the song
        frame.add(new JButton("Song2")); // TODO connect this to the controller and use a for loop for songs
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GuiGetRecSong("English");
    }
}
