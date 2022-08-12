package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the page only available for admin users, tasks include: ban, delete, and promote a normal user.
 */
public class GuiAdminTasks {


    public GuiAdminTasks(final String language, final String purpose, final ShellState shell) {
        final LanguageFactory languageFactory = new LanguageFactory();
        JPanel panel = new JPanel();
        final JFrame frame = new JFrame();
        if (purpose == "promote"){
            frame.setTitle(languageFactory.translateTo(language).chooseUserToPromote());
        }else if (purpose == "ban"){
            frame.setTitle(languageFactory.translateTo(language).chooseUserToBan());
        }else{
            frame.setTitle(languageFactory.translateTo(language).chooseUserToDelete());
        }
        final JLabel messageLabel = new JLabel();
        messageLabel.setBounds(10,250,700,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));
        messageLabel.setForeground(Color.red);

        JButton backButton = new JButton(languageFactory.translateTo(language).back());
        backButton.setBounds(400,10,80,25);



        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label = new JLabel(languageFactory.translateTo(language).userName());
        label.setBounds(10, 20, 80, 25);

        final JTextField userNameField = new JTextField();
        userNameField.setBounds(100, 20, 165, 25);

        JButton confirmButton = new JButton(languageFactory.translateTo(language).confirm());
        confirmButton.setBounds(10, 80, 80, 25);

        panel.add(label);
        panel.add(userNameField);
        panel.add(confirmButton);
        panel.add(messageLabel);
        panel.add(backButton);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String currentUsername = shell.getUserProfile().getUsername();
                if (shell.getLoginController().getUserController().isAdmin(currentUsername)){
                    new GuiAdminUser(language,shell);
                    frame.dispose();
                }else{
                    new GuiNormalUser(language, shell);
                    frame.dispose();
                }
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String message = "";
                String currentUserName = shell.getUserProfile().getUsername();
                if (purpose == "promote"){
                    message = shell.getLoginController().getUserController().createAdminUser(currentUserName,userName);


                }else if(purpose == "delete"){
                    message = shell.getLoginController().getUserController().deleteUser(currentUserName,userName);
                }else{
                    message = shell.getLoginController().getUserController().banUser(currentUserName,userName);
                }
                if (message == "Command Successful!"){
                    messageLabel.setText(languageFactory.translateTo(language).adminTaskComplete());
                }else{
                    messageLabel.setText(languageFactory.translateTo(language).adminTaskFailed());
                }
            }
        });

    }
}
