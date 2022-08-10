package GUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class is used for Register.
 */
class GuiRegister extends JDialog{
    public static void main(String[] args) {
        new GuiRegister("English");
    }

    public GuiRegister(final String language) {
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateto(language).registerSystem());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel(languageGetter.translateto(language).userID());
        userLabel.setBounds(10, 20, 80, 25);
        JTextField userLink = new JTextField(20);
        userLink.setBounds(100, 20, 165, 25);

        JLabel passwordLabel = new JLabel(languageGetter.translateto(language).password());
        passwordLabel.setBounds(10, 50, 80, 25);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);

        JButton registerButton = new JButton(languageGetter.translateto(language).register());
        registerButton.setBounds(10, 80, 80, 25);
        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);

        panel.add(userLabel);
        panel.add(userLink);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(registerButton);
        panel.add(success);



        UserAndPassword userAndPassword = new UserAndPassword();
        //User enter
        passwordText.addActionListener(userAndPassword);
        userLink.addActionListener(userAndPassword);
        //Password enter
        passwordText.addActionListener(userAndPassword);
        userLink.addActionListener(userAndPassword);

        //设置替换编码
        passwordText.setEchoChar('*'); //char ///////

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if ...
                new GuiSign(language); // TODO connect to the controller
                frame.dispose();
            }
        });

        frame.setVisible(true);

    }

    /**
     * This class gets the source for the user and the password that the customer entered.
     */
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
