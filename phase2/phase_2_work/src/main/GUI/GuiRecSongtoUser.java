package GUI;

import javax.swing.*;

class GuiRecSongtoUser extends JDialog {
    private static JLabel label;
    private static JTextField UserName, UrlLink;
    private static JButton button;


    public GuiRecSongtoUser(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Recommend song to users");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //search song's Url
        label = new JLabel("Song's URL:");
        label.setBounds(10,20,80,25);
        panel.add(label);
        UrlLink = new JTextField();
        UrlLink.setBounds(100,20,165,25);
        panel.add(UrlLink);

        button = new JButton("Search");
        button.setBounds(10,80,80,25);
        panel.add(button);


        //search User's name
        label = new JLabel("User's name:");
        label.setBounds(10,150,80,25);
        panel.add(label);
        UserName = new JTextField();
        UserName.setBounds(100,150,165,25);
        panel.add(UserName);
        frame.setVisible(true);

        button = new JButton("Search");
        button.setBounds(10,220,80,25);
        panel.add(button);
    }

}