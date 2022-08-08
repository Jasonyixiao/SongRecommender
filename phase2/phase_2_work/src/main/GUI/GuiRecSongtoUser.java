package GUI;

import javax.swing.*;

class GuiRecSongtoUser extends JDialog {
    private static JLabel songUrlLabel, nameUrlLabel;
    private static JTextField UserName, UrlLink;
    private static JButton searchButton;


    public GuiRecSongtoUser(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Recommend song to users");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //search song's Url
        songUrlLabel = new JLabel("Song's URL:");
        songUrlLabel.setBounds(10,20,80,25);
        UrlLink = new JTextField();
        UrlLink.setBounds(100,20,165,25);
        searchButton = new JButton("Search");
        searchButton.setBounds(10,80,80,25);


        //search User's name
        nameUrlLabel = new JLabel("User's name:");
        nameUrlLabel.setBounds(10,150,80,25);
        UserName = new JTextField();
        UserName.setBounds(100,150,165,25);
        searchButton = new JButton("Search");
        searchButton.setBounds(10,220,80,25);

        panel.add(songUrlLabel);
        panel.add(UrlLink);
        panel.add(searchButton);
        panel.add(nameUrlLabel);
        panel.add(UserName);
        panel.add(searchButton);
        frame.setVisible(true);
    }

}