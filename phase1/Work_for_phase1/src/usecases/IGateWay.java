package usecases;

import entities.Song;
import entities.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public interface IGateWay {
    void save(Serializable o, String path) throws IOException;
    HashMap<String, User>  read_user() throws ClassNotFoundException;
    HashMap<String, Song> read_song() throws ClassNotFoundException;

    String getSongFile();

    String getUserFile();
}
