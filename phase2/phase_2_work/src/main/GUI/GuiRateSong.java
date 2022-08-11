package GUI;

import controllers.ShellState;

import javax.swing.*;

/**
 * This class is responsible for the user to rate the song.
 */
public class GuiRateSong extends JDialog{

//    public static void main(String[] args) {
//        new GuiRateSong("English", shell);
//    }
    public GuiRateSong(String language, ShellState shell){
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(languageGetter.translateTo(language).songName()); //SongName get from song.csv

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel songName = new JLabel(languageGetter.translateTo(language).songName());
        JLabel rate = new JLabel(languageGetter.translateTo(language).rate());
        rate.setBounds(10,50,280,25);
        songName.setBounds(10,20,280,25 );
        panel.add(rate);
        panel.add(songName);

        JTextField rateField = new JTextField(5);
        rateField.setBounds(200,50,45,25);
        panel.add(rateField);
        JTextField songNameField = new JTextField();
        songNameField.setBounds(200,20,45,25);
        panel.add(songNameField);

        frame.setVisible(true);


        JLabel recommend = new JLabel(languageGetter.translateTo(language).recommend());
        recommend.setBounds(10,80,80,25);
        panel.add(recommend);
        panel.setLayout(null);
        JButton button = new JButton(languageGetter.translateTo(language).yes());
        button.setBounds(150,80,150,25);
        panel.add(button);



    }

}
