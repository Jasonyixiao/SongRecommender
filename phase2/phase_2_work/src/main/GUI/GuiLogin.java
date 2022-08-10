package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiLogin extends JDialog{ // when press sign in button
//    public static void main(String[] args) {
//        new GuiLogin("English");
//    } // we will put english for now

    public GuiLogin(final String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateto(language).loginSystem());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel userId = new JLabel(languageGetter.translateto(language).userID());
        userId.setBounds(10, 20, 80, 25);
        JTextField userLink = new JTextField(20);
        userLink.setBounds(100, 20, 165, 25);

        JLabel passwordLabel = new JLabel(languageGetter.translateto(language).password());
        passwordLabel.setBounds(10, 50, 80, 25);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);

        JButton loginButton = new JButton(languageGetter.translateto(language).login());
        loginButton.setBounds(10, 80, 80, 25);

        panel.add(userId);
        panel.add(userLink);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);


        //enter->出发输入框事件
        UserAndPassword userAndPassword = new UserAndPassword();
        passwordText.addActionListener(userAndPassword);
        userLink.addActionListener(userAndPassword);
        //设置替换编码
        passwordText.setEchoChar('*'); //char

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO change this so that we can check is this user is normal user or admin user
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

