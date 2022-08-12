package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class is the rate song page when the user click on a particular song on the home page to rate.
 */
public class GuiRateOutOf5 {

    public GuiRateOutOf5(final String language, final ShellState shell, final String songName){ // might need to add: ShellState shell;
        final LanguageFactory languageFactory = new LanguageFactory();
        final JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageFactory.translateTo(language).registerSystem());
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //Add a place to enter rating
        JLabel label = new JLabel(languageFactory.translateTo(language).rate() + " :" + songName +
                " (0-5)");
        label.setBounds(140, 20, 200, 25);
        final JTextField username = new JTextField(20);
        username.setBounds(200, 40, 165, 25);
        panel.add(username);
        panel.add(label);


        JButton rateButton = new JButton(languageFactory.translateTo(language).rate());
        rateButton.setBounds(200, 60, 80, 25);
        panel.add(rateButton);

        //Back button(return to main page:
        JButton button2 = new JButton(languageFactory.translateTo(language).back());
        button2.setBounds(400,10,80,25);
        panel.add(button2); //
        frame.setVisible(true);

        //Add message label:
        final JLabel message = new JLabel();
        message.setBounds(100, 100, 200, 25);
        message.setFont(new Font(null,Font.ITALIC,15));
        message.setForeground(Color.red);
        panel.add(message);

        //Add action for back button:
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSongPage(language, shell, songName);
                frame.dispose();
            }
        });

        //Add action for rate:
        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rating = username.getText();
                float num = Float.parseFloat(rating);
                try {
                    shell.getSongController().rateASong(songName, num);
                    message.setText(languageFactory.translateTo(language).rateSongSucceed());

                    new GuiSongPage(language, shell, songName);
                    frame.dispose();

                } catch (IOException ex) {
                    message.setText(languageFactory.translateTo(language).rateSongSaveFailed());
                }

            }
        });
    }
}
