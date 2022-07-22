package controllers;

import usecases.NotificationCenter;

public class RecommendController {

    NotificationCenter notificationCenter;

    SongController songController;

    int currentNotificationId;
;
    public RecommendController(SongController songController, NotificationCenter notificationCenter) {
        this.songController = songController;
    }

    public String getMessage(String username, int idOfNotification) {
        return notificationCenter.getNotificationMessage(username, idOfNotification);
    }

    public String getContent(String username, int idOfNotification) {
        return notificationCenter.getNotificationContent(username, idOfNotification);
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



}
