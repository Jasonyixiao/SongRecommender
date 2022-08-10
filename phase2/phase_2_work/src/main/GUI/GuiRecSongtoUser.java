package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for the user to recommend a specific song to another user.
 */
class GuiRecSongtoUser extends JDialog {
    public static void main(String[] args) {
        new GuiRecSongtoUser("English");
    }


    public GuiRecSongtoUser(final String language){
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateto(language).recommendToUser());
        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JButton button2 = new JButton(languageGetter.translateto(language).back());
        button2.setBounds(400,10,80,25);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminUser(language); // here we need to add a if statement to check if the current user is normal user or admin user
                frame.dispose();
            }
        });

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