package GUI;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.*;

public class GuiSign {
    public GuiSign(){
        JFrame frame = new JFrame();
        JButton button = new JButton("Sign in");
        JButton button1 = new JButton("Register");
        JLabel label1 = new JLabel("For New User");
        JLabel label = new JLabel("For Existed User");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        panel1.setBorder(BorderFactory.createEmptyBorder(200,200,200,200));
        panel.setLayout(new GridLayout(3,3));
        panel1.setLayout(new GridLayout(5,6));
        panel.add(button);
        panel.add(label);
        panel1.add(button1);
        panel1.add(label1);
        frame.add(panel,BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel1,BorderLayout.CENTER);
        frame.setTitle("Welcome");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new GuiSign();
    }
}
