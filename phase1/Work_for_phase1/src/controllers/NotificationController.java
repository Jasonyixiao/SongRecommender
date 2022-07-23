package controllers;

import usecases.NotificationCenter;

public class NotificationController {

    NotificationCenter notificationCenter;

    SongController songController;

    int currentNotificationId;
    public NotificationController(SongController songController, NotificationCenter notificationCenter) {
        this.songController = songController;
        this.notificationCenter = notificationCenter;
    }

    public String getMessage(String username, int idOfNotification) {
        if (notificationCenter.hasUser(username)) {
            return notificationCenter.getNotificationMessage(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }

    public int getTotalNumMesage(String username) {
        return notificationCenter.getTotalNumNotifications(username);
    }

    public String getContent(String username, int idOfNotification) {
        if (notificationCenter.hasUser(username)) {
            return notificationCenter.getNotificationContent(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }

    public String getSender(String username, int idOfNotification) {
        if (notificationCenter.hasUser(username)) {
            return getSender(username, idOfNotification);
        } else {
            return "No such Notification. ";
        }
    }

    public int getNumofNewNotifications(String currentUser) {
        return notificationCenter.getNumberOfNewNotifications(currentUser);
    }

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

    public void setContent(String username, int idOfNotification, String content) { // we use this to add url to the notification
        if(notificationCenter.hasUser(username)) {
            notificationCenter.setContent(username, idOfNotification, content);
        }
    }

    public void setmessage(String username, int idOfNotification, String message) { // we use this to add message to the notification
        if(notificationCenter.hasUser(username)) {
            notificationCenter.setMessage(username, idOfNotification, message);
        }
    }

    public void setIsRead(String username, int idOfNotification, boolean isRead) {
        if(notificationCenter.hasUser(username)) {
            notificationCenter.setIsRead(username, idOfNotification, isRead);
        }
    }

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
