package GUI;

import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiFriend {
    public GuiFriend() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Friend");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.add(new JButton("Friend"));
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GuiFriend();
    }
}
