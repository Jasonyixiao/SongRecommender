package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiListen extends JDialog{
//    public static void main(String[] args) {
//        new GuiListen("English");
//    }


    public GuiListen(final String language, final ShellState shell){
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).listen());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel(languageGetter.translateTo(language).songURL());
        label.setBounds(10,20,80,25);

        JTextField urlLink = new JTextField();
        urlLink.setBounds(100,20,165,25);

        JButton button = new JButton(languageGetter.translateTo(language).search());
        button.setBounds(10,80,80,25);

        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        button2.setBounds(400,10,80,25);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAdminUser(language,shell); // here we need to add a if statement to check if the current user is normal user or admin user
                frame.dispose();
            }
        });


        panel.add(label);
        panel.add(urlLink);
        panel.add(button);
        panel.add(button2);
        frame.setVisible(true);
    }

}

