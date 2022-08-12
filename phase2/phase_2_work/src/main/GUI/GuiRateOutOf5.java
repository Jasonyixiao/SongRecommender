package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class GuiRateOutOf5 {
//    public static void main(String[] args) {
//        new GuiRateOutOf5("English", "Shivers");
//    }
    public GuiRateOutOf5(final String language, final ShellState shell, final String songName){ // might need to add: ShellState shell;
        final LanguageGetter languageGetter = new LanguageGetter();
        final JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).registerSystem());
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //Add a place to enter rating
        JLabel label = new JLabel(languageGetter.translateTo(language).rate() + " :" + songName +
                " (0-5)");
        label.setBounds(140, 20, 200, 25);
        final JTextField username = new JTextField(20);
        username.setBounds(200, 40, 165, 25);
        panel.add(username);
        panel.add(label);


        JButton rateButton = new JButton(languageGetter.translateTo(language).rate());
        rateButton.setBounds(200, 60, 80, 25);
        panel.add(rateButton);

        //Back button(return to main page:
        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        button2.setBounds(400,10,80,25);
        panel.add(button2); // TODO add action for button2 which return to the GuiSongPage
        frame.setVisible(true);

        //Add success label:
        final JLabel success = new JLabel();
        success.setBounds(100, 100, 200, 25);
        panel.add(success);

        //Add action for back button:
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSongPage(language, shell, songName);
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
                    new GuiSongPage(language, shell, songName);
                    frame.dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JLabel success = new JLabel();
                success.setFont(new Font(null,Font.ITALIC,15));
                success.setForeground(Color.red);
                success.setText(languageGetter.translateTo(language).Succeeded());
            }
        });
    }
}
