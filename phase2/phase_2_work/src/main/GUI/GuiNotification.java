package GUI;

import controllers.ShellState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class is the notification page.
 */
public class GuiNotification {

    public GuiNotification(final String language, final ShellState shell) {
        LanguageFactory languageFactory = new LanguageFactory();
        final JFrame frame = new JFrame(languageFactory.translateTo(language).notification());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));

        // Add a menu bar and add dropdown menus to it:
        JButton button2 = new JButton(languageFactory.translateTo(language).back());
        frame.add(button2);



        JLabel messageLabel = new JLabel();
        messageLabel.setFont(new Font(null,Font.ITALIC,15));
        messageLabel.setForeground(Color.red);

        frame.setLayout(new GridLayout(3, 1, 10, 10));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(messageLabel);

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

        //Getting all the notifications, and make notifications clickable
        try{ final String currentUser = shell.getUserProfile().getUsername();
            System.out.println(shell.getNotificationController().getSender(currentUser,0));
            int numAllNotifications = shell.getNotificationController().getTotalNumMessage(currentUser);
            for (int i = 0; i < numAllNotifications; i++) {
                JButton songButton = new JButton(languageFactory.translateTo(language).youHaveMessageFrom()
                        + shell.getNotificationController().getSender(currentUser, i) +
                        ". " + languageFactory.translateTo(language).songName() + ": "
                        + shell.getNotificationController().getSongName(currentUser, i) +
                        ". " + languageFactory.translateTo(language).message() + ": "
                        + shell.getNotificationController().getMessage(currentUser, i));
                final int num = i;
                    panel.add(songButton);
                    songButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new GuiSongPage(
                                    language,
                                    shell,
                                    shell.getNotificationController().getSongName(currentUser, num));
                            frame.dispose();
                        }
                    });
            }
            frame.setVisible(true);

        }catch(NullPointerException e){
            messageLabel.setText(languageFactory.translateTo(language).noNotification());
        }


    }


}
