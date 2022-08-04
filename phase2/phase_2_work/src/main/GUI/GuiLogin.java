package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLogin implements ActionListener{

    private static JLabel userLaber;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button1;
    private static JLabel success;


    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        userLaber = new JLabel("User ID");
        userLaber.setBounds(10, 20, 80, 25);
        panel.add(userLaber);
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button1 = new JButton("Login");
        button1.setBounds(10, 80, 80, 25);
        button1.addActionListener(new GuiLogin());
        panel.add(button1);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);


        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText(); //have to change the getText() if it's not working

        if(user.equals("A") && password.equals("1")){ //here we have to import the variable in controller???
            success.setText("Login successful.");
        }
        else if(user.equals("A") && (!password.equals("1"))){
            success.setText("Login fail");
        }


    }
}