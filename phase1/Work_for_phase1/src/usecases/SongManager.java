package usecases;

import entities.Notification;
import entities.Song;
import entities.User;
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

    private final NotificationCenter notificationCenter;


    public SongManager(IGateWay g) {
        this.allSongs = new HashMap<>(9999);
        this.gateWay = g;
        this.notificationCenter = new NotificationCenter();
    }

    public HashMap<String, Song> getAllSongs() {
        return allSongs;
    }

    public void addSong(String name, String url, String artist) {
        allSongs.put(name, new Song(url, name, artist));
    }

    public void recommendSong(String songName, String receiverUsername) {
        Song song = allSongs.get(songName);
        Notification notification = new Notification(song.getSongUrl());
        notificationCenter.addNotification(receiverUsername, notification);
    }

    public void rate(String songName, float point) {
        allSongs.get(songName).rate(point);
    }


    public String listen(String songName){ // we will return the url for now
        return allSongs.get(songName).getSongUrl();
    }


    public float displayCurrentRating(String songName) {
        return allSongs.get(songName).getAvgRating();
    }

    public List<String> getRecommend(int amount, Recommender recommender) {
        return recommender.getRecommend(amount, allSongs.values());
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
    public boolean has_song(String songName){
        return allSongs.get(songName) != null;
    }
}
