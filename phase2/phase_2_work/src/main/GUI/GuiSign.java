package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This Class is responsible for User to choose log in or Register.
 */
class GuiSign extends JDialog {
    public static void main(String[] args) {
        new GuiSign("English");
    }

    public GuiSign(final String language){  //first frame shows the register button and sign in button.
        final JFrame frame = new JFrame();

        LanguageGetter languageGetter = new LanguageGetter();
        JButton button1 = new JButton(languageGetter.translateto(language).login());
        JButton button2 = new JButton(languageGetter.translateto(language).register());

        JLabel label1 = new JLabel(languageGetter.translateto(language).forExistedUser());
        JLabel label2 = new JLabel(languageGetter.translateto(language).forNewUser());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setBorder(BorderFactory.createEmptyBorder(200, 150, 200, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(200, 250, 200, 150));

        panel1.setLayout(new GridLayout(3, 3));
        panel2.setLayout(new GridLayout(3, 3));

        panel1.add(button1); // exsit user
        panel1.add(label1);
        panel2.add(button2);//new user
        panel2.add(label2);
        frame.add(panel1, BorderLayout.LINE_START);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel2, BorderLayout.LINE_END);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLogin(language);
                frame.dispose();
            }
        });



        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRegister(language);
                frame.dispose();
            }
        });

        // LoginJBAction(button1);
        frame.setTitle(languageGetter.translateto(language).welcome());
        frame.pack();
        frame.setVisible(true);


        // MyActionListener myActionListener = new MyActionListener();
        // button1.addActionListener(myActionListener);
    }

}

//class MyActionListener implements ActionListener {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Hiiii");
//    }
//}
