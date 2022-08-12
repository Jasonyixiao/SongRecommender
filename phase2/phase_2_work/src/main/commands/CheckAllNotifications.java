package commands;

import controllers.ShellState;

import java.io.IOException;

/**
 * This Class is responsible for checking all the notifications a user has.
 */
public class CheckAllNotifications implements ICommands {
    public CheckAllNotifications() {

    }

    /**
     * This method will show user all their notifications.
     * @param state is the current state of the program
     * @return message regarding the outcome of the task.
     * @throws IOException
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        try {
            String currentUser = state.getUserProfile().getUsername();
            int numAllNotifications = state.getNotificationController().getTotalNumMessage(currentUser);
            if (numAllNotifications == 0) {
                return "You do not have any Notifications";
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
