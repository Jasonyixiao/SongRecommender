package GUI;

import javax.swing.*;
import java.awt.*;

public class GuiSong1{
    public static void main(String[] args){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("SongName"); //SongName get from song.csv

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);


        JLabel rate = new JLabel("Rate（Use 1-5 any characters present stars) ");
        rate.setBounds(20,20,300,25);
        panel.add(rate);

        JTextField rateField = new JTextField(5);
        rateField.setBounds(350,20,45,25);
        panel.add(rateField);
        frame.setVisible(true);


        JLabel recommend = new JLabel("Recommend");
        recommend.setBounds(10,80,80,25);
        panel.add(recommend);
        panel.setLayout(null);

        JButton button = new JButton("Yes");
        button.setBounds(150,80,150,25);
        panel.add(button);

    }

}
