package commands;

import controllers.ShellState;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is responsible for checking new notifications for program user.
 */
public class CheckNewNotification implements ICommands {

    public CheckNewNotification() {

    }

    /**
     * This method will check if there is any new notifications for the program user.
     * @param state
     * @return whether the user has succeeded. Or return further instructions if the user did not succeed.
     * @throws IOException
     */

    @Override
    public String executeCommand(ShellState state) throws IOException {
        try {
            String currentUser = state.getUserProfile().getUsername();
            int numNewNotifications = state.getNotificationController().getNumofNewNotifications(currentUser);
            Scanner sc = new Scanner(System.in);
            if (numNewNotifications == 0) {
                return "You do not have any new Notifications. If you's like to view all notifications enter: " +
                        "View All Notifications";
            } else {
                System.out.println("You have " + numNewNotifications + " new notifications. Which notification " +
                        "you would you like to view? Enter a number from 1 to " + numNewNotifications);
                try {
                    int notificationId = Integer.parseInt(sc.nextLine());
                    System.out.println("You have a message from "
                            + state.getNotificationController().getSender(currentUser, notificationId));
                    System.out.println("Message: "
                            + state.getNotificationController().getContent(currentUser, notificationId));
                    System.out.println("Content: "
                            + state.getNotificationController().getMessage(currentUser, notificationId));
                    return "";
                } catch(Exception e) {
                    return "Invalid Input";
                }

            }
        } catch (Exception e) {
            return "Please Login First. ";
        }
    }
}
