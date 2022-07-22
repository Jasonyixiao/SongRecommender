package usecases;

import entities.Notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This class is responsible for managing all the notifications being sent from a user to another users.
 */
public class NotificationCenter {
    HashMap<String, List<Notification>> allNotifications; // username to list of notifications
    // we save this, so we later can find all the notifications a user have


    /**
     * Constructor for NotificationCenter, initialize all notifications in the system.
     */
    public NotificationCenter() {
        this.allNotifications = new HashMap<>();
    }


    /**
     * Getter for a notification's content.
     * @param notification is the notification we wish to find content of.
     * @return the notification's content.
     */
    public String getNotificationContent(Notification notification) {
        return notification.getContent();
    }


    /**
     * This method will add a notification to the system.
     * @param username is the receiving user's username.
     * @param notification is the notification we wish to send to user specified by username.
     */
    public void addNotification(String username, Notification notification) {
        if (allNotifications.containsKey(username)) {
            List<Notification> lst = this.allNotifications.get(username);
            lst.add(notification);
        }
        else{
            List<Notification> listAllNotifications = new ArrayList<>();
            listAllNotifications.add(notification);
            allNotifications.put(username, listAllNotifications);
        }
    }


}
