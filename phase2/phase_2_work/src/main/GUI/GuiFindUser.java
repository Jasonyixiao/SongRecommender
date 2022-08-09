package GUI;

import javax.swing.*;

public class GuiFindUser {
    private static JLabel label;
    private static JTextField UserName;
    private static JButton button;

    public GuiFindUser(String title) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame(title);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        label = new JLabel("User name:");
        label.setBounds(10, 20, 80, 25);

        UserName = new JTextField();
        UserName.setBounds(100, 20, 165, 25);

        button = new JButton("Search");
        button.setBounds(10, 80, 80, 25);

        panel.add(label);
        panel.add(UserName);
        panel.add(button);
        frame.setVisible(true);
    }
}
