package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiHistory {
    public GuiHistory() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Login History");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton("Login History1:")); // get rid of "login History 1"... just put 1, 2, 3 instead
        frame.add(new JButton("Login History2:")); // or use a for loop
        frame.add(new JButton("Login History3:"));
        frame.add(new JButton("Login History4:"));
        frame.add(new JButton("Login History5:"));
        frame.add(new JButton("Login History6:"));
        frame.add(new JButton("Login History7:"));
        frame.add(new JButton("Login History8:"));
        frame.add(new JButton("Login History9:"));
        frame.add(new JButton("Login History10:"));
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GuiHistory();
    }
}
