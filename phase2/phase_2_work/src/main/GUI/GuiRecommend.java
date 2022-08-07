package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;

class GuiRecommend {
    private static JMenuBar mb;
    private static JMenu m1, m2, m3, m4, m5;

    private static JMenuItem m11, m12, m21, m31, m32, m41, m42;

    public GuiRecommend() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Homepage(NormalUser)");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));

        mb = new JMenuBar();
        m1 = new JMenu("User");
        m2 = new JMenu("Listen");
        m3 = new JMenu("admin");
        m4 = new JMenu("notification");
        m5 = new JMenu("get recommend");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);

        m11 = new JMenuItem("User Information");
        m12 = new JMenuItem("Log Out");
        m1.add(m11);
        m1.add(m12);
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSign();
            }
        });
        m21 = new JMenuItem("url");
        m2.add(m21);
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiListen();     //go inside the URL page
            }
        });
        m31 = new JMenuItem("User");
        m32 = new JMenuItem("Self");
        m3.add(m31);
        m3.add(m32);

        m41 = new JMenuItem("Receive");
        m42 = new JMenuItem("Send");
        m4.add(m41);
        m4.add(m42);


        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.add(new JButton("song1"));
        frame.add(new JButton("song2"));
        frame.add(new JButton("song3"));
        frame.add(new JButton("song4"));
        frame.add(new JButton("song5"));
        frame.add(new JButton("song6"));
        frame.add(new JButton("song7"));
        frame.add(new JButton("song8"));
        frame.add(new JButton("song9"));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiRecommend();
    }
}