package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLogin {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login System");
        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label = new JLabel("User ID");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);
        JTextField UserLink = new JTextField(20);
        UserLink.setBounds(100, 20, 165, 25);
        panel.add(UserLink);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        JButton button1 = new JButton("Login");
        button1.setBounds(10, 80, 80, 25);
        panel.add(button1);
        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);


    }
}