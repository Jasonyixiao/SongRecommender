package usecases;

import entities.Notification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This class is responsible for managing all the notifications being sent from a user to another users.
 */
public class NotificationCenter {
    HashMap<String, List<Notification>> allNotifications; // username to list of notifications
    // we save this, so we later can find all the notifications a user have
    private final IGateWay gateWay;


    /**
     * Constructor for NotificationCenter, initialize all notifications in the system.
     * @param g is the instance of IGateWay we use to save data.
     */
    public NotificationCenter(IGateWay g) {
        this.allNotifications = new HashMap<>();
        this.gateWay = g;
    }

    /**
     * This method returns the number of new notifications for a user.
     * @param username is the username of the user we are checking.
     * @return the number of new notification a user has.
     */

    public int getNumberOfNewNotifications(String username) {
        List<Notification> notifications = allNotifications.get(username);
        int numNew = 0;
        try {
            for (Notification notification : notifications) {
                if (notification.getIsNew()) {
                    numNew += 1;
                }
            }
        } catch(Exception e) {
            return 0;
        }
        return numNew;
    }



    /**
     * This method returns the number of notifications for a user.
     * @param username is the username of the user we are checking.
     * @return the number of notification a user has.
     */
    public int getTotalNumNotifications(String username) {
        return allNotifications.get(username).size();
    }


    /**
     * This method returns the username of the sender of the notification sent to a user.
     * @param username is the username of the receiver.
     * @param idOfNotification is the index of the notification sent to the user.
     * @return the username of the sender.
     */
    public String getSender(String username, int idOfNotification) {
        return allNotifications.get(username).get(idOfNotification).getSender();
    }

    /**
     * This method gets the content of a notification sent to a user.
     * @param username is the username of the receiving user.
     * @param idOfNotification is the index of the notification we are checking.
     * @return content(url of the song for now) of the notification.
     */
    public String getNotificationContent(String username, int idOfNotification) {
        return allNotifications.get(username).get(idOfNotification).getContent();
    }

    /**
     * This method gets the message of a notification sent to a user.
     * @param username is the username of the receiving user.
     * @param idOfNotification is the index of the notification we are checking.
     * @return message of the notification.
     */
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


    /**
     * This method creates a notification.
     * @param receiver is the receiving user's username.
     * @param sender is the sending user's username.
     * @return the index of the notification in the receiving user's list of all notifications.
     */
    public int createNotification(String receiver, String sender) { // this returns the index of this newly created notification
        Notification notification = new Notification();
        notification.setSender(sender);
        addNotification(receiver, notification);
        return allNotifications.get(receiver).size() - 1;
    }

    /**
     * This method checks if a user has at least one notification.
     * @param username is the username of the user we are checking.
     * @return true iff the user has at least one notification.
     */
    public boolean hasUser(String username) {
        return this.allNotifications.containsKey(username);
    }


    /**
     * Sets the content(url for now) for a notification.
     * @param username is the receiving user's username.
     * @param idOfNotification is the index of notification we wish to set content for.
     * @param content is the content we are setting.
     */
    public void setContent(String username, int idOfNotification, String content) { // we use this to add url to the notification
            allNotifications.get(username).get(idOfNotification).setContent(content);
    }
    /**
     * Sets the message for a notification.
     * @param username is the receiving user's username.
     * @param idOfNotification is the index of notification we wish to set message for.
     * @param message is the content we are setting.
     */
    public void setMessage(String username, int idOfNotification, String message) { // we use this to add message to the notification
            allNotifications.get(username).get(idOfNotification).setMessage(message);
    }

    /**
     * Sets the read status of a notification.
     * @param username is the username of the receiver.
     * @param idOfNotification is the index of the notification we are setting.
     * @param isRead is true if read, false if unread.
     */
    public void setIsRead(String username, int idOfNotification, boolean isRead) {
            allNotifications.get(username).get(idOfNotification).setIsRead(isRead);
    }

    /**
     * Saves the current notification data locally to the notification data file.
     */
    public void save(){
        try {
            gateWay.save(allNotifications, gateWay.getNotificationFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reads in the notifications data and saves them as a HashMap<String, List<Notification>> into allNotifications.
     */
    public void read(){
        try {
            allNotifications = gateWay.readNotification();
        } catch (ClassNotFoundException ignored) {
        }
    }








}
