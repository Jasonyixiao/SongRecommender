package GUI;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiNewNotification {

    public GuiNewNotification() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("GuiNotification");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.add(new JButton("New Notification"));
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GuiNewNotification();
    }
}