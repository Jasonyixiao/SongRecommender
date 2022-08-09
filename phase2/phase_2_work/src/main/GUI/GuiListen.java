package GUI;

import javax.swing.*;
import java.awt.*;
class GuiListen extends JDialog{
    public static void main(String[] args) {
        new GuiListen();
    }
    private static JLabel label;
    private static JTextField UrlLink;
    private static JButton button;


    public GuiListen(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Listen");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        label = new JLabel("Song URL");
        label.setBounds(10,20,80,25);

        UrlLink = new JTextField();
        UrlLink.setBounds(100,20,165,25);

        button = new JButton("Search");
        button.setBounds(10,80,80,25);

        panel.add(label);
        panel.add(UrlLink);
        panel.add(button);
        frame.setVisible(true);
    }

}

