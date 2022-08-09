package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiLogin extends JDialog{ // when press sign in button
//    public static void main(String[] args) {
//        new GuiLogin("English");
//    } // we will put english for now

    private static JLabel UserId, passwordLabel;
    private static JTextField UserLink;
    private static JPasswordField passwordText;
    private static JButton loginButton;

    public GuiLogin(final String language) {
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame("Login System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        UserId = new JLabel("User ID");
        UserId.setBounds(10, 20, 80, 25);
        UserLink = new JTextField(20);
        UserLink.setBounds(100, 20, 165, 25);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);

        panel.add(UserId);
        panel.add(UserLink);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);


        //enter->出发输入框事件
        UserAndPassword userAndPassword = new UserAndPassword();
        passwordText.addActionListener(userAndPassword);
        UserLink.addActionListener(userAndPassword);
        //设置替换编码
        passwordText.setEchoChar('*'); //char

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiNormalUser(language);
                new GuiAdminUser(language);
                frame.dispose();
            }
        });

        frame.setVisible(true);

    }

    //@SuppressWarnings("unchecked")

    //private void LoginJBAction(java.awt.event.ActionEvent evt){
    //    dispose();
    //    GuiLogin guiLogin = new GuiLogin();
    //    guiLogin.setVisible(true);
    //}

    static class UserAndPassword implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JTextField field = (JTextField) e.getSource(); //获得资源，返回对象
            System.out.println(field.getText()); //获得输入框中的文本

            //if User d.n.e
            field.setText("");
            //System.out.println("Please Register first."); 也许要加新的page for instruction?

            //if password is Wrong:
            //field.setText(""); // set empty
            //System.out.println("Wrong Password."); 也许要加新的page for instruction?

            //if User and password correct
            //if normal
            //go to homepage-normal
            //if Admin
            //go to homepage-Admin

        }
    }
}

