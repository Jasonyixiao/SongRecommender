package controllers;

import usecases.NotificationCenter;

import java.io.IOException;

/**
 * This Class is responsible for calling the necessary methods for user to perform notifications-related tasks
 */
public class NotificationController {

    private NotificationCenter notificationCenter;

    private SongController songController;

    private int currentNotificationId;

    /**
     * Constructor for NotificationController. Stores SongController and NotificationCenter as variables.
     * @param songController is responsible for calling the necessary methods for user to perform song-related tasks
     * @param notificationCenter is responsible for managing all the notifications being sent from a
     *                           user to another user.
     */
    public NotificationController(SongController songController, NotificationCenter notificationCenter) {
        this.songController = songController;
        this.notificationCenter = notificationCenter;
    }

    /**
     * This method will get the message of the Notification specified by idOfNotification received
     * by user specified by username.
     * @param username is the username of the received user.
     * @param idOfNotification is the index of the notification.
     * @return the message of the notification, or return a message indicating there is not such notification
     *         for this user.
     */
    public String getMessage(String username, int idOfNotification) {
        if (notificationCenter.hasUser(username)) {
            return notificationCenter.getNotificationMessage(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }

    /**
     * This method will get the total number of notification for the user specified by username.
     * @param username is the username of the user.
     * @return the number of notifications.
     */
    public int GetTotalNumMessage (String username) throws NullPointerException {
        return notificationCenter.getTotalNumNotifications(username);
    }


    /**
     * This method will get the content(url for now) of the Notification specified by idOfNotification received
     * by user specified by username.
     * @param username is the username of the received user.
     * @param idOfNotification is the index of the notification.
     * @return the content of the notification, or return a message indicating there is not such notification
     *         for this user.
     */
    public String getContent(String username, int idOfNotification) {
        if (notificationCenter.hasUser(username)) {
            return notificationCenter.getNotificationContent(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }


    /**
     * This message will return the sender of the notification.
     * @param username is the username of the receiving user.
     * @param idOfNotification is the index of the notification.
     * @return the username of the sender, or a message indicating there is no such notification if there is no
     * notification sent to this user.
     */
    public String getSender(String username, int idOfNotification) {
        if (notificationCenter.hasUser(username)) {
            return notificationCenter.getSender(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }


    /**
     * This method will return the number of new notifications.
     * @param currentUser is the current user's username.
     * @return the number of new notifications.
     */

    public int getNumOfNewNotifications(String currentUser) {
        return notificationCenter.getNumberOfNewNotifications(currentUser);
    }


    /**
     * This method will let user recommend a song to another user.
     * @param songName is the name of the song being recommended.
     * @param receiver is the username of the receiving user.
     * @param sender is the username of the sending user.
     * @param  message is the message of this notification.
     * @return a boolean the user has succeeded.
     */
    public Boolean recommendSong(String songName, String receiver, String sender, String message) {
        if (songController.hasSong(songName)) {
            String songURL = songController.listen(songName);
            int index = notificationCenter.createNotification(receiver,sender,songURL, message); // This creates a new notification and added it to notification center
            currentNotificationId = index;
            return true;
        } else {
            return false;
        }
    }




    /**
     * This method will save the notification data.
     * @throws  IOException if error finding directory.
     */
    public void saveNotificationData() throws IOException {
        notificationCenter.save();
    }




}
