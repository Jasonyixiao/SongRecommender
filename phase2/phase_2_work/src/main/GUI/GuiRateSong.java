package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for the user to rate the song.
 */
public class GuiRateSong extends JDialog{

//    public static void main(String[] args) {
//        new GuiRateSong("English", shell);
//    }
    public GuiRateSong(final String language, final ShellState shell){
        final LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(languageGetter.translateTo(language).songName()); //SongName get from song.csv

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel songName = new JLabel(languageGetter.translateTo(language).songName());
        JLabel giveYourRating = new JLabel(languageGetter.translateTo(language).giveYourRating());
        giveYourRating.setBounds(10,50,280,25);
        songName.setBounds(10,20,280,25 );
        panel.add(giveYourRating);
        panel.add(songName);
        final JLabel messageLabel = new JLabel();
        messageLabel.setBounds(40,250,700,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));
        messageLabel.setForeground(Color.red);
        panel.add(messageLabel);

        final JTextField rateField = new JTextField(5);
        rateField.setBounds(200,50,45,25);
        panel.add(rateField);
        final JTextField songNameField = new JTextField();
        songNameField.setBounds(200,20,45,25);
        panel.add(songNameField);

        frame.setVisible(true);


        panel.setLayout(null);
        JButton rateButton = new JButton(languageGetter.translateTo(language).rate());
        rateButton.setBounds(150,120,150,25);
        panel.add(rateButton);

        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float rating = Float.parseFloat(rateField.getText());
                String songName = songNameField.getText();
                if(shell.getSongController().rateASong(songName,rating)){
                    messageLabel.setText(languageGetter.translateTo(language).rateSongSuccess());
                } else{
                    messageLabel.setText(languageGetter.translateTo(language).rateSongFailed());
                }


            }
        });



    }

}
