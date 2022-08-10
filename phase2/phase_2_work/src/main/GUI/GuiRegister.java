package GUI;
import controllers.LoginController;
import controllers.ShellState;
import controllers.SongController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for registering.
 */
class GuiRegister extends JDialog{

    public GuiRegister(final String language, final ShellState shell) {
        LanguageGetter languageGetter = new LanguageGetter();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame(languageGetter.translateTo(language).registerSystem());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel(languageGetter.translateTo(language).userID());
        label.setBounds(10, 20, 80, 25);
        final JTextField username = new JTextField(20);
        username.setBounds(100, 20, 165, 25);

        JLabel passwordLabel = new JLabel(languageGetter.translateTo(language).password());
        passwordLabel.setBounds(10, 50, 80, 25);
        final JPasswordField password = new JPasswordField();
        password.setBounds(100, 50, 165, 25);

        JButton registerButton = new JButton(languageGetter.translateTo(language).register());
        registerButton.setBounds(10, 80, 80, 25);
        final JLabel success = new JLabel();
        success.setBounds(10, 110, 300, 25);

        panel.add(label);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(registerButton);
        panel.add(success);
        frame.setVisible(true);



        password.setEchoChar('*');

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = username.getText();
                String userPassword = String.valueOf(password.getPassword());
                if(shell.getLoginController().getUserController().createNormalUser(userID, userPassword)
                        == "User Created, Please Login."){
                new GuiSign(language,shell);
                frame.dispose();
                }else{
                    success.setFont(new Font(null,Font.ITALIC,25));
                    success.setForeground(Color.red);
                    success.setText("User already exists, please try again");
                }
            }
        });




    }

}
