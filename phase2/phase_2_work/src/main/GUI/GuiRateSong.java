package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class is the page for the user to search song name and rate songs.
 */
public class GuiRateSong extends JDialog{


    public GuiRateSong(final String language, final ShellState shell){
        final LanguageFactory languageFactory = new LanguageFactory();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageFactory.translateTo(language).songName()); //SongName get from song.csv

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel songName = new JLabel(languageFactory.translateTo(language).songName());
        JLabel giveYourRating = new JLabel(languageFactory.translateTo(language).giveYourRating());
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
        JButton rateButton = new JButton(languageFactory.translateTo(language).rate());
        rateButton.setBounds(150,120,150,25);
        panel.add(rateButton);
        JButton button2 = new JButton(languageFactory.translateTo(language).back());
        button2.setBounds(400,10,80,25);
        panel.add(button2); //
        frame.setVisible(true);


        button2.addActionListener(new ActionListener() {
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
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float rating = Float.parseFloat(rateField.getText());
                String songName = songNameField.getText();
                try {
                    if(shell.getSongController().rateASong(songName,rating)){
                        messageLabel.setText(languageFactory.translateTo(language).rateSongSuccess());
                    } else{
                        messageLabel.setText(languageFactory.translateTo(language).rateSongFailed());
                    }
                } catch (IOException ex) {
                        messageLabel.setText(languageFactory.translateTo(language).rateSongSaveFailed());

                }


            }
        });



    }

}
