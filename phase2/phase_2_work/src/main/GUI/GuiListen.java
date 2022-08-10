package GUI;

import javax.swing.*;
import java.awt.*;
class GuiListen extends JDialog{
    public static void main(String[] args) {
        new GuiListen("English");
    }


    public GuiListen(String language){
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(languageGetter.translateto(language).listen());
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel(languageGetter.translateto(language).songURL());
        label.setBounds(10,20,80,25);

        JTextField urlLink = new JTextField();
        urlLink.setBounds(100,20,165,25);

        JButton button = new JButton(languageGetter.translateto(language).search());
        button.setBounds(10,80,80,25);

        panel.add(label);
        panel.add(urlLink);
        panel.add(button);
        frame.setVisible(true);
    }

}

