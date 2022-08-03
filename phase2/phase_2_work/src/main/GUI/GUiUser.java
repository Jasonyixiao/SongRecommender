package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUiUser {


    public static void main(String[] args){

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(500,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        JTextField userText = new JTextField();

        frame.setVisible(true);
        panel.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);






    }
}
