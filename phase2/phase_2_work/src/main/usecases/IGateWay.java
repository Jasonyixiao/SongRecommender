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
    void save(Serializable o, String path) throws IOException;
    HashMap<String, User> readUser() throws ClassNotFoundException;
    HashMap<String, Song> readSong() throws ClassNotFoundException;

    HashMap<String, List<Notification>> readNotification() throws ClassNotFoundException;

    String getSongFile();

    String getUserFile();

    String getNotificationFile();

}
