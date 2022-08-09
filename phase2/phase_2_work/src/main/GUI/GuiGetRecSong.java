package GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiGetRecSong {

    public GuiGetRecSong() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Recommend Songs");
        frame.setSize(500, 250);
        frame.setLayout(new GridLayout(5, 1, 10, 0));
        frame.add(new JButton("Song1")); // again we will change "song1".... to the name of the song
        frame.add(new JButton("Song2"));
        frame.add(new JButton("Song3"));
        frame.add(new JButton("Song4"));
        frame.add(new JButton("Song5"));
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GuiGetRecSong();
    }
}
