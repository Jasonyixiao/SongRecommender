package GUI;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.*;

public class GuiRecommend {
    public GuiRecommend() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Homepage(NormalUser)");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("User");
        JMenu m2 = new JMenu("Listen");
        JMenu m3 = new JMenu("admin");
        JMenu m4 = new JMenu("notification");
        JMenu m5 = new JMenu("get recommend");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);

        JMenuItem m11 = new JMenuItem("User Information");
        JMenuItem m12 = new JMenuItem("Log Out");
        m1.add(m11);
        m1.add(m12);

        JMenuItem m21 = new JMenuItem("url");
        m2.add(m21);

        JMenuItem m31 = new JMenuItem("User");
        JMenuItem m32 = new JMenuItem("Self");
        m3.add(m31);
        m3.add(m32);

        JMenuItem m41 = new JMenuItem("Receive");
        JMenuItem m42 = new JMenuItem("Send");
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