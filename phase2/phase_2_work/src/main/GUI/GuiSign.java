package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiSign extends JDialog {
    public static void main(String[] args) {
        new GuiSign();
    }

    private static JButton button1, button2;
    private static JLabel label1, label2;
    private static JPanel panel1, panel2;

    public GuiSign(){  //first frame shows the register button and sign in button.
        JFrame frame = new JFrame();

        button1 = new JButton("Sign in");
        button2 = new JButton("Register");

        label1 = new JLabel("For Existed User");
        label2 = new JLabel("For New User");

        panel1 = new JPanel();
        panel2 = new JPanel();

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
                new GuiLogin();
            }
        });



        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiRegister();
            }
        });

        // LoginJBAction(button1);
        frame.setTitle("Welcome");
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
