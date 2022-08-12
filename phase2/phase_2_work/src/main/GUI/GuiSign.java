package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This page is for User to choose log in or Register.
 */
class GuiSign extends JDialog {


    public GuiSign(final String language, final ShellState shell){  //first frame shows the register button and sign in button.
        final JFrame frame = new JFrame();

        LanguageFactory languageFactory = new LanguageFactory();
        JButton button1 = new JButton(languageFactory.translateTo(language).login());
        JButton button2 = new JButton(languageFactory.translateTo(language).register());

        JLabel label1 = new JLabel(languageFactory.translateTo(language).forExistedUser());
        JLabel label2 = new JLabel(languageFactory.translateTo(language).forNewUser());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setBorder(BorderFactory.createEmptyBorder(200, 100, 200, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(200, 250, 200, 100));
        panel3.setBorder(BorderFactory.createEmptyBorder(250, 150, 100, 150));

        panel1.setLayout(new GridLayout(3, 3));
        panel2.setLayout(new GridLayout(3, 3));

        panel1.add(button1); // exit user
        panel1.add(label1);
        panel2.add(button2);//new user
        panel2.add(label2);
        frame.add(panel1, BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel2, BorderLayout.LINE_END);
        frame.add(panel3);

        //Back button(return to main page:
        JButton backButton = new JButton(languageFactory.translateTo(language).back());
        button2.setBounds(400,500,80,25);
        panel3.add(backButton);
        //Add actionlistener to button2
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiChooseLanguage(shell);
                frame.dispose();
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLogin(language, shell);
                frame.dispose();
            }
        });



        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRegister(language, shell);
                frame.dispose();
            }
        });

        // LoginJBAction(button1);
        frame.setTitle(languageFactory.translateTo(language).welcome());
        frame.pack();
        frame.setVisible(true);



    }

}

