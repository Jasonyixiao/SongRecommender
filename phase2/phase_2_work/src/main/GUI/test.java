package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class test {
    public static void main(String[] args) {
        new test("English");
    }
    public test(final String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateto(language).notification());
        frame.setSize(500, 500);
        JScrollPane jScrollPane = new JScrollPane();
        frame.add(jScrollPane);
        jScrollPane.add(new JButton("Login History1:"));
        jScrollPane.add(new JButton("Login History1:"));
        jScrollPane.add(new JButton("Login History1:"));
        jScrollPane.add(new JButton("Login History1:"));
        jScrollPane.add(new JButton("Login History1:"));


        frame.setVisible(true);

    }
}
