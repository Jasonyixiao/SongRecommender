package GUI;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.*;

public class GuiSign {
    public GuiSign(){
        JFrame frame = new JFrame();

        JButton button = new JButton("Sign in");
        JButton button1 = new JButton("Register");

        JLabel label = new JLabel("For Existed User");
        JLabel label1 = new JLabel("For New User");

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(200,150,200,250));
        panel1.setBorder(BorderFactory.createEmptyBorder(200,250,200,150));

        panel.setLayout(new GridLayout(3,3));
        panel1.setLayout(new GridLayout(3,3));

        panel.add(button);
        panel.add(label)
        ;
        panel1.add(button1);
        panel1.add(label1);

        frame.add(panel,BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel1,BorderLayout.LINE_END);
        frame.setTitle("Welcome");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new GuiSign();
    }
}
