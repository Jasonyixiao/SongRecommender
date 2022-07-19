package usecases;

import entities.Song;
import recommendStrategy.Recommender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class will allow the system users to do stuff with a song.
 */
public class SongManager {

    private HashMap<String, Song> allSongs;

    private final IGateWay gateWay;




    public SongManager(IGateWay g) {
        this.allSongs = new HashMap<>(9999);
        this.gateWay = g;
    }

    public HashMap<String, Song> getAllSongs() {
        return allSongs;
    }

    public void addSong(String name, String url, String artist) {
        allSongs.put(name, new Song(url, name, artist));
    }


    public void rate(String songName, float point) {
        allSongs.get(songName).addPoints(point);
        allSongs.get(songName).addRatedPeople();
    }


    //public String listen(String songName){}
    //what do we do here?


    public float displayCurrentRating(String songName) {
        return allSongs.get(songName).getAvgRating();
    }

    public List<String> getRecommend(int amount, Recommender recommender) {
        return recommender.getRecommend(amount, allSongs);
    }

    public String getURL(String name) {
        return allSongs.get(name).getSongUrl();
    }

    public void read() {
        try {
            allSongs = gateWay.read_song();
        } catch (ClassNotFoundException ignored) {
        }
    }

    public void save() {
        try {
            gateWay.save(allSongs, gateWay.getSongFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
