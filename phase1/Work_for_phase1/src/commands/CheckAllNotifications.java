package commands;

import controllers.ShellState;

import java.io.IOException;

public class CheckAllNotifications implements Commands{
    public CheckAllNotifications() {

    }

    @Override
    public String executeCommand(ShellState state) throws IOException {
        try {
            String currentUser = state.getUserProfile().getUsername();
            int numAllNotifications = state.getNotificationController().getNumofNewNotifications(currentUser);
            if (numAllNotifications == 0) {
                return "You do not have any new Notifications";
            } else {
                for (int i = 0; i < numAllNotifications; i++) {
                    System.out.println("You have a message from "
                            + state.getNotificationController().getSender(currentUser, i));
                    System.out.println("Message: "
                            + state.getNotificationController().getContent(currentUser, i));
                    System.out.println("Content: "
                            + state.getNotificationController().getMessage(currentUser, i));
                    System.out.println(" ");
                }
                return "";
            }
        } catch (Exception e) {
            return "Please Login First.";
        }
    }
}
