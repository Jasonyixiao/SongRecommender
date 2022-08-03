package GUI;

import commands.Ban;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.*;
public class GuiRecommendAdmin {
    public GuiRecommendAdmin() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setTitle("SONG RECOMMEND");
    frame.setSize(500, 500);
    frame.setLayout(new GridLayout(10, 1, 10, 0));
    JMenuBar mb = new JMenuBar();
    JMenu m1 = new JMenu("User");
    JMenu m2 = new JMenu("Listen");
    JMenu m3 = new JMenu("Ban");
    JMenu m4 = new JMenu("Delete");
    JMenu m5 = new JMenu("Notification");
    JMenu m6 = new JMenu("Admin");
    JMenu m7 = new JMenu("Get Recommend");

    mb.add(m1);
    mb.add(m2);
    mb.add(m3);
    mb.add(m4);
    mb.add(m5);
    mb.add(m6);
    mb.add(m7);
    JMenuItem m11 = new JMenuItem("User Information");
    JMenuItem m22 = new JMenuItem("Log Out");
    m1.add(m11);
    m1.add(m22);
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
        new GuiRecommendAdmin();
    }

}
