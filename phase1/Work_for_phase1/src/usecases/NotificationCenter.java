package usecases;

import entities.Notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotificationCenter {

    HashMap<String, List<Notification>> allNotifications; // username to list of notifications
    // we save this, so we later can find all the notifications a user have
    NotificationCenter() {
        this.allNotifications = new HashMap<>();
    }


    public String getNotificationContent(Notification notification) {
        return notification.getContent();
    }

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
