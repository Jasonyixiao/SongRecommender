package controllers;

import usecases.NotificationCenter;

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
    public int getTotalNumMesage(String username) {
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
            return getSender(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }


    /**
     * This method will return the number of new notifications.
     * @param currentUser is the current user's username.
     * @return the number of new notifications.
     */

    public int getNumofNewNotifications(String currentUser) {
        return notificationCenter.getNumberOfNewNotifications(currentUser);
    }


    /**
     * This method will let user recommend a song to another user.
     * @param songName is the name of the song being recommended.
     * @param receiver is the username of the receiving user.
     * @param sender is the username of the sending user.
     * @return a message whether the user has succeeded. Or return further instructions if the user did not succeed.
     */
    public String recommendSong(String songName, String receiver, String sender) {
        if (songController.hasSong(songName)) {
            String songURL = songController.listen(songName);
            int index = notificationCenter.createNotification(receiver, sender); // This creates a new notification and added it to notification center
            notificationCenter.setContent(receiver, index, songURL);
            currentNotificationId = index;
            return "Successfully recommended to " + receiver;
        } else {
            return "Song does not exist, try again! ";
        }
    }

    /**
     * Sets the content(url for now) for a notification.
     * @param username is the receiving user's username.
     * @param idOfNotification is the index of notification we wish to set content for.
     * @param content is the content we are setting.
     */
    public void setContent(String username, int idOfNotification, String content) { // we use this to add url to the notification
        if(notificationCenter.hasUser(username)) {
            notificationCenter.setContent(username, idOfNotification, content);
        }
    }


    /**
     * Sets the message for a notification.
     * @param username is the receiving user's username.
     * @param idOfNotification is the index of notification we wish to set message for.
     * @param message is the message we are setting.
     */
    public void setmessage(String username, int idOfNotification, String message) { // we use this to add message to the notification
        if(notificationCenter.hasUser(username)) {
            notificationCenter.setMessage(username, idOfNotification, message);
        }
    }


    /**
     * Sets the read status of a notification.
     * @param username is the username of the receiver.
     * @param idOfNotification is the index of the notification we are setting.
     * @param isRead is true if read, false if unread.
     */
    public void setIsRead(String username, int idOfNotification, boolean isRead) {
        if(notificationCenter.hasUser(username)) {
            notificationCenter.setIsRead(username, idOfNotification, isRead);
        }
    }

    /**
     * Getter for index of the current notification we are working with.
     * @return a index of current notification.
     */
    public int getIdOfCurrentNotification () {
        return this.currentNotificationId;
    }


    /**
     * This method will save the notification data.
     */
    public void saveNotificationData(){
        notificationCenter.save();
    }




}
