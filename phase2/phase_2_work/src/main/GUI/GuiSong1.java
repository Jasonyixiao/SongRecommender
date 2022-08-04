package GUI;

import javax.swing.*;
import java.awt.*;

public class GuiSong1{
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel rate;
    private static JTextField rateField;
    private static JLabel recommend;
    private static JButton button;


    public static void main(String[] args){
        panel = new JPanel();
        frame = new JFrame("SongName"); //SongName get from song.csv

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);


        rate = new JLabel("Rate（Use 1-5 any characters present stars) ");
        rate.setBounds(10,20,280,25);
        panel.add(rate);

        rateField = new JTextField(5);
        rateField.setBounds(300,20,45,25);
        panel.add(rateField);
        frame.setVisible(true);


        recommend = new JLabel("Recommend");
        recommend.setBounds(10,80,80,25);
        panel.add(recommend);
        panel.setLayout(null);
        button = new JButton("Yes");
        button.setBounds(150,80,150,25);
        panel.add(button);

    }

}
