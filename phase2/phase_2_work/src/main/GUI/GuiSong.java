package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiSong {
    public GuiSong() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // SongName = ...//import the song name from song.csv file
        frame.setTitle("SongName"); //get it from song.csv file
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 0));
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("rate");
        JMenu m2 = new JMenu("recommend");

        mb.add(m1);
        mb.add(m2);


        JMenuItem m11 = new JMenuItem("User Information");
        JMenuItem m12 = new JMenuItem("Log Out");
        m1.add(m11);
        m1.add(m12);

        JMenuItem m21 = new JMenuItem("url");
        m2.add(m21);


        frame.getContentPane().add(BorderLayout.NORTH, mb);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiSong();
    }
}

