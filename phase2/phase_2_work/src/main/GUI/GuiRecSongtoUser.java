package GUI;

import javax.swing.*;

class GuiRecSongtoUser extends JDialog {


    public GuiRecSongtoUser(String language){
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(languageGetter.translateto(language).recommendToUser());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //search song's Url
        JLabel songUrlLabel = new JLabel(languageGetter.translateto(language).songURL());
        songUrlLabel.setBounds(10,20,80,25);
        JTextField urlLink = new JTextField();
        urlLink.setBounds(100,20,165,25);
        JButton searchButton = new JButton(languageGetter.translateto(language).search());
        searchButton.setBounds(10,80,80,25);


        //search User's name
        JLabel nameUrlLabel = new JLabel(languageGetter.translateto(language).userName());
        nameUrlLabel.setBounds(10,150,80,25);
        JTextField userName = new JTextField();
        userName.setBounds(100,150,165,25);
        searchButton = new JButton(languageGetter.translateto(language).search());
        searchButton.setBounds(10,220,80,25);

        panel.add(songUrlLabel);
        panel.add(urlLink);
        panel.add(searchButton);
        panel.add(nameUrlLabel);
        panel.add(userName);
        panel.add(searchButton);
        frame.setVisible(true);
    }

}