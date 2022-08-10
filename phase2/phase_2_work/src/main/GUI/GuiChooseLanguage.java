package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiChooseLanguage extends JDialog {
    public static void main(String[] args) {
        new GuiChooseLanguage();
    }

    public GuiChooseLanguage() {

        final JFrame frame = new JFrame();
        JButton button1 = new JButton("English");
        JButton button2 = new JButton("中文");

        JLabel label1 = new JLabel("For English User");
        JLabel label2 = new JLabel("中文页面");


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBorder(BorderFactory.createEmptyBorder(200, 150, 200, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(200, 250, 200, 150));

        panel1.setLayout(new GridLayout(3, 3));
        panel2.setLayout(new GridLayout(3, 3));

        panel1.add(button1); // exsit user
        panel1.add(label1);
        panel2.add(button2);//new user
        panel2.add(label2);
        frame.add(panel1, BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel2, BorderLayout.LINE_END);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign("English");
                frame.dispose();
            }
        });



        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign("Chinese");
                frame.dispose();
            }
        });

        // LoginJBAction(button1);
        frame.setTitle("welcome");
        frame.pack();
        frame.setVisible(true);
    }
}
