package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;
public class GuiAdminUser {

    private static JMenuBar mb;
    private static JMenu m1, m2, m3, m4, m5, m6, m7, m8;
    private static JMenuItem m11, m12, m21, m31, m32, m61, m62, m71, m72;

    public GuiAdminUser() {
    JFrame frame = new JFrame("Homepage-Admin User");
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setLayout(new GridLayout(10, 1, 10, 0));
    mb = new JMenuBar();
    m1 = new JMenu("User");
    m2 = new JMenu("Listen");
    m3 = new JMenu("Notification");
    m4 = new JMenu("Get Recommend");
    m5 = new JMenu("Friend");
    m6 = new JMenu("Admin");
    m7 = new JMenu("Ban");
    m8 = new JMenu("Delete");

    mb.add(m1);
    mb.add(m2);
    mb.add(m3);
    mb.add(m4);
    mb.add(m5);
    mb.add(m6);
    mb.add(m7);
    mb.add(m8);

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

    m31 = new JMenuItem("Send");
    m32 = new JMenuItem("Received");
    m3.add(m31);
    m3.add(m32);

    m61 = new JMenuItem("User");
    m62 = new JMenuItem("Self");
    m6.add(m61);
    m6.add(m62);


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
        new GuiAdminUser();
    }

}
