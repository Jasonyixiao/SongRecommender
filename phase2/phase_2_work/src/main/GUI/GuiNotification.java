package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class is the notification page.
 */
public class GuiNotification {

    public GuiNotification(String notificationType, final String language, final ShellState shell) {
        LanguageGetter languageGetter = new LanguageGetter();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(languageGetter.translateTo(language).notification());
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        frame.add(panel);
         JLabel messageLabel = new JLabel();
        messageLabel.setBounds(125,250,300,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));
        messageLabel.setForeground(Color.red);



        frame.setLayout(new GridLayout(10, 1, 10, 0));
        JButton button2 = new JButton(languageGetter.translateTo(language).back());
        button2.setBounds(400, 10, 80, 25);
        panel.add(button2);
        panel.add(messageLabel);
        frame.setVisible(true);


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentUsername = shell.getUserProfile().getUsername();
                if (shell.getLoginController().getUserController().isAdmin(currentUsername)) {
                    new GuiAdminUser(language, shell);
                    frame.dispose();
                } else {
                    new GuiNormalUser(language, shell);
                    frame.dispose();
                }
            }
        });

        //Getting all the notifications.
        try{ String currentUser = shell.getUserProfile().getUsername();
            System.out.println(shell.getNotificationController().getSender(currentUser,0));
            int numAllNotifications = shell.getNotificationController().GetTotalNumMessage(currentUser);
            for (int i = 0; i < numAllNotifications; i++) {
                    panel.add(new JButton( languageGetter.translateTo(language).youHaveMessageFrom()
                            + shell.getNotificationController().getSender(currentUser, i)+
                            ". " + languageGetter.translateTo(language).urlOfTheSongIs() + ": "
                            + shell.getNotificationController().getContent(currentUser, i)+
                            ". " + languageGetter.translateTo(language).message() + ": "
                            + shell.getNotificationController().getMessage(currentUser, i))
                    );
            }
            frame.setVisible(true);

        }catch(NullPointerException e){
            messageLabel.setText(languageGetter.translateTo(language).noNotification());
        }


    }


}
