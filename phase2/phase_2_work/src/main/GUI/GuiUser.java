package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiUser {
    public static void main(String[] args) {
        new GuiUser();
    }
    public GuiUser() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Users");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton("User1")); // replace "User1" ...  with usernames
        frame.add(new JButton("User2"));
        frame.add(new JButton("User3"));
        frame.add(new JButton("User4"));
        frame.add(new JButton("User5"));
        frame.add(new JButton("User6"));
        frame.add(new JButton("User7"));
        frame.add(new JButton("User8"));
        frame.add(new JButton("User9"));
        frame.add(new JButton("User10"));
        frame.setVisible(true);

    }

}
