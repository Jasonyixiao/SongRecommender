package GUI;

import javax.swing.*;

/**
 * This class is responsible for the user to rate the song.
 */
public class GuiRateSong extends JDialog{


    public GuiRateSong(String[] args, String language){
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(languageGetter.translateto(language).songName()); //SongName get from song.csv

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);


        JLabel rate = new JLabel(languageGetter.translateto(language).rate());
        rate.setBounds(10,20,280,25);
        panel.add(rate);

        JTextField rateField = new JTextField(5);
        rateField.setBounds(300,20,45,25);
        panel.add(rateField);
        frame.setVisible(true);


        JLabel recommend = new JLabel(languageGetter.translateto(language).recommend());
        recommend.setBounds(10,80,80,25);
        panel.add(recommend);
        panel.setLayout(null);
        JButton button = new JButton(languageGetter.translateto(language).yes());
        button.setBounds(150,80,150,25);
        panel.add(button);

    }

}
