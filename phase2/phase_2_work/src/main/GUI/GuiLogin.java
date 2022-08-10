package GUI;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import controllers.UserProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for logging in.
 */
class GuiLogin extends JDialog implements ActionListener { // when press sign in button

    LanguageGetter languageGetter = new LanguageGetter();
    JPanel panel = new JPanel();
    JFrame frame;
    JLabel userId;
    JLabel passwordLabel;
    JButton loginButton;
    JPasswordField passwordField;
    JTextField userNameField;
    ShellState shell;
    String language;
    JLabel messageLabel = new JLabel();



    public GuiLogin(final String language, final ShellState shell) {
        this.frame = new JFrame(languageGetter.translateTo(language).loginSystem());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        this.userId = new JLabel(languageGetter.translateTo(language).userID());
        userId.setBounds(10, 20, 80, 25);
        this.userNameField = new JTextField(20);
        userNameField.setBounds(100, 20, 165, 25);

        this.passwordLabel = new JLabel(languageGetter.translateTo(language).password());
        passwordLabel.setBounds(10, 50, 80, 25);
        this.passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        this.loginButton = new JButton(languageGetter.translateTo(language).login());
        loginButton.setBounds(10, 80, 80, 25);

        panel.add(userId);
        panel.add(userNameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(messageLabel);
        frame.setVisible(true);
        loginButton.addActionListener( this);

        this.shell = shell;
        this.language = language;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userNameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            UserController userController = shell.getLoginController().getUserController();
            LoginController loginController = shell.getLoginController();
            UserProfile userContext = loginController.Login(username, password);
            shell.setUserProfile(userContext);
            if (userContext != null) {
                if (userController.isAdmin(username)) {
                    new GuiAdminUser(language, shell);
                    frame.dispose();
                } else {
                    new GuiNormalUser(language, shell);
                    frame.dispose();
                }
            }else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Invalid username/password.");
            }

        }

    }
}




