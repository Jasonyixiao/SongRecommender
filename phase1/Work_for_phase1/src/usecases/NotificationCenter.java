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

    public int getNumberOfNewNotifications(String username) {
        List<Notification> notifications = allNotifications.get(username);
        int numNew = 0;
        for (Notification notification : notifications) {
            if (notification.getIsNew()) {
                numNew += 1;
            }
        }
        return numNew;
    }

    public String getNotificationContent(String username, int idOfNotification) {
        return allNotifications.get(username).get(idOfNotification).getContent();
    }

    public String getNotificationMessage(String username, int idOfNotification) {
        return allNotifications.get(username).get(idOfNotification).getMessage();
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

    public int createNotification(String receiver, String sender) { // this returns the index of this newly created notification
        Notification notification = new Notification();
        notification.setSender(sender);
        addNotification(receiver, notification);
        return allNotifications.get(receiver).size() - 1;
    }

    public boolean hasUser(String username) {
        return this.allNotifications.containsKey(username);
    }
    public void setContent(String username, int idOfNotification, String content) { // we use this to add url to the notification
            allNotifications.get(username).get(idOfNotification).setContent(content);
    }

    public void setMessage(String username, int idOfNotification, String message) { // we use this to add message to the notification
            allNotifications.get(username).get(idOfNotification).setMessage(message);
    }

    public void setIsRead(String username, int idOfNotification, boolean isRead) {
            allNotifications.get(username).get(idOfNotification).setIsRead(isRead);
    }






    //Todo we need a read and save method

//    public Notification createNotification() {
//        return new Notification();
//    }
//
//    public void addMessage(Notification notification, String message) {
//        notification.setMessage(message);
//    }
//
//    public void addContent(Notification notification, String content) {
//        notification.setContent(content);
//    }
//
//    public void addSender(Notification notification, String username) {
//        notification.setSender(username);
//    }
//


}
