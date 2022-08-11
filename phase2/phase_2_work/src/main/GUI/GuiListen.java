package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for listening to the songs.
 */
class GuiListen extends JDialog{
//    public static void main(String[] args) {
//        new GuiListen("English");
//    }


    public GuiListen(final String language, final ShellState shell){
        final LanguageGetter languageGetter = new LanguageGetter();
        final JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).listen());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel(languageGetter.translateTo(language).songName());
        label.setBounds(10,20,80,25);

        final JTextField songToListen = new JTextField();
        songToListen.setBounds(100,20,165,25);
        final JLabel messageLabel = new JLabel();
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));
        messageLabel.setForeground(Color.red);
        panel.add(messageLabel);
        JButton button = new JButton(languageGetter.translateTo(language).search());
        button.setBounds(10,80,80,25);

        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        button2.setBounds(400,10,80,25);

        panel.add(label);
        panel.add(songToListen);
        panel.add(button);
        panel.add(button2);
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

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String listenTo = songToListen.getText();
                if (shell.getSongController().hasSong(listenTo)){
                    String url = shell.getSongController().listen(listenTo);
                    messageLabel.setText(languageGetter.translateTo(language).hereIsUrl()+url);
                }else{
                    messageLabel.setText(languageGetter.translateTo(language).noSongFound());
                }


            }
        });


    }

}

