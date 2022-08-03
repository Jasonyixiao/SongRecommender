package GUI;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.*;

public class SongLayout {
    public static void main(String args[]){
        JFrame songLayout = new JFrame("GridLayout");
        Button song1 = new Button("Song1");
        Button song2 = new Button("Song2");
        Button song3 = new Button("Song3");
        Button song4 = new Button("Song4");
        Button song5 = new Button("Song5");
        Button song6 = new Button("Song6");
        Button song7 = new Button("Song7");
        Button song8 = new Button("Song8");
        Button song9 = new Button("Song9");
        songLayout.setLayout(new GridLayout(3,3));

        songLayout.add(song1);
        songLayout.add(song2);
        songLayout.add(song3);
        songLayout.add(song4);
        songLayout.add(song5);
        songLayout.add(song6);
        songLayout.add(song7);
        songLayout.add(song8);
        songLayout.add(song9);
        songLayout.pack();
        songLayout.setVisible(true);

    }
}
