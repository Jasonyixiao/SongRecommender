package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for the user to recommend a specific song to another user.
 */
class GuiRecSongToUser extends JDialog {



    public GuiRecSongToUser(final String language, final ShellState shell){
        final LanguageFactory languageFactory = new LanguageFactory();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageFactory.translateTo(language).recommendToUser());
        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JButton backButton = new JButton(languageFactory.translateTo(language).back());
        backButton.setBounds(400,10,80,25);

        backButton.addActionListener(new ActionListener() {
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

        //search song's Url
        final JLabel songName= new JLabel(languageFactory.translateTo(language).songName());
        songName.setBounds(10,20,165,25);
        final JTextField songNameField = new JTextField();
        songNameField.setBounds(200,20,165,25);
        final JLabel messageLabel = new JLabel();
        messageLabel.setBounds(125,250,400,35);


        JLabel message = new JLabel(languageFactory.translateTo(language).enterMessage());
        message.setBounds(10,85,165,25);
        final JTextField messageField = new JTextField();
        messageField.setBounds(200, 85, 200 , 25);


        //search User's name
        JLabel receiver = new JLabel(languageFactory.translateTo(language).receiverUsername());
        receiver.setBounds(10,150,165,25);
        final JTextField receiverField = new JTextField();
        receiverField.setBounds(200,150,165,25);
        JButton recommendButton = new JButton(languageFactory.translateTo(language).recommend());
        recommendButton.setBounds(10,220,200,25);

        panel.add(messageLabel);
        panel.add(songName);
        panel.add(songNameField);
        panel.add(recommendButton);
        panel.add(receiver);
        panel.add(receiverField);
        panel.add(recommendButton);
        panel.add(message);
        panel.add(backButton);
        panel.add(messageField);
        frame.setVisible(true);


        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String song = songNameField.getText();
                String receiver = receiverField.getText();
                String message = messageField.getText();
                String currentUser = shell.getUserProfile().getUsername();
                if(shell.getNotificationController().recommendSong(song,receiver,currentUser,message)){
                    messageLabel.setFont(new Font(null, Font.ITALIC, 15));
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText(languageFactory.translateTo(language).recommendSucceeded());

                }else{
                    messageLabel.setFont(new Font(null, Font.ITALIC, 15));
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText(languageFactory.translateTo(language).recommendFailed());

                }

            }
        });
    }

}