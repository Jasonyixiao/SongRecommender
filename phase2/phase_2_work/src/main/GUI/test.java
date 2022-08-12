package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {
    public static void main(String[] args) {
        new test("English");
    }
    public test(final String language) {
        LanguageFactory languageFactory = new LanguageFactory();
        JFrame testFrame = new JFrame("ramka testowa");
        JPanel jPanel = new JPanel();
        testFrame.setLayout(new GridLayout(10, 1));
        jPanel.setLayout(new GridLayout(1, 8));

        //backbutton
        JMenuBar button2 = new JMenuBar();
        JMenuItem jMenuItem = new JMenuItem(languageFactory.translateTo(language).back());
        button2.add(jMenuItem);
        jPanel.add(button2);

        testFrame.add(jPanel);

        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.add(new JButton("ded"));


        JButton button = new JButton("gotolink");
        jPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String songurl = "https://www.youtube.com/watch?v=BqwAvw2GgUU";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(songurl));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });


        testFrame.setSize(400, 400);
        testFrame.setVisible(true);

    }
}
