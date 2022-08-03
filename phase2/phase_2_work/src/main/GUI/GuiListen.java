package GUI;

import javax.swing.*;
import java.awt.*;
public class GuiListen{
    public static void main(String[] args){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Listen");
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label = new JLabel("Song URL");
        label.setBounds(10,20,80,25);
        panel.add(label);
        JTextField UrlLink = new JTextField();
        UrlLink.setBounds(100,20,165,25);
        panel.add(UrlLink);
        frame.setVisible(true);
        JButton button = new JButton("Search");
        button.setBounds(10,80,80,25);
        panel.add(button);
    }

}
