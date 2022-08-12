package usecases;

import entities.Notification;
import entities.Song;
import entities.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Interface for saving and reading the program's data.
 */
public interface IGateWay {
    void save(Serializable o, String path) throws IOException;     //throws IOException when can't find the path on the computer.
    HashMap<String, User> readUser() throws ClassNotFoundException;     //Throws ClassNotFoundException when can't find the local .ser file on the computer.
    HashMap<String, Song> readSong() throws ClassNotFoundException;     //Throws ClassNotFoundException when can't find the local .ser file on the computer.

    HashMap<String, List<Notification>> readNotification() throws ClassNotFoundException;      //Throws ClassNotFoundException when can't find the local .ser file on the computer.

    String getSongFile();

    String getUserFile();

    String getNotificationFile();

}
