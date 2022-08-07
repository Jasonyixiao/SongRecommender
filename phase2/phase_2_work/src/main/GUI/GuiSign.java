package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;

class GuiSign extends JDialog {
    private static JLabel label;
    private static JLabel label1;
    private static JButton button;
    private static JButton button1;
    private static JPanel panel;
    private static JPanel panel1;


    public GuiSign() {  //first frame shows the register button and sign in button.
        JFrame frame = new JFrame();

        button = new JButton("Sign in");
        button1 = new JButton("Register");

        label = new JLabel("For Existed User");
        label1 = new JLabel("For New User");

        panel = new JPanel();
        panel1 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(200, 150, 200, 250));
        panel1.setBorder(BorderFactory.createEmptyBorder(200, 250, 200, 150));

        panel.setLayout(new GridLayout(3, 3));
        panel1.setLayout(new GridLayout(3, 3));

        panel.add(button); // exsit user
        panel.add(label);
        panel1.add(button1);//new user
        panel1.add(label1);
        frame.add(panel, BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel1, BorderLayout.LINE_END);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLogin();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRegister();
            }
        });
        frame.setTitle("Welcome");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiSign();
    }

}
