package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
        JFrame testFrame = new JFrame("ramka testowa");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0, 1));
        testFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setSize(10, 10);

        JMenu userInfoMenu = new JMenu(languageGetter.translateTo(language).userInfo()); //return "user information" in chinese
        userInfoMenu.setSize(10, 10);
        jMenuBar.add(userInfoMenu);


        JMenuItem checkHistoryButton = new JMenuItem(languageGetter.translateTo(language).checkHistory());
        JMenuItem logoutButton = new JMenuItem(languageGetter.translateTo(language).logout());

        userInfoMenu.add(checkHistoryButton);
        userInfoMenu.add(logoutButton);


        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel.add(new JButton("ded"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));
        jPanel.add(new JButton("dsds"));



        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jPanel);
        testFrame.add(scrollPane, BorderLayout.CENTER);
        testFrame.setSize(400, 400);
        testFrame.setVisible(true);

    }
}
