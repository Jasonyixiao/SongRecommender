package controllers;

import recommendStrategy.Recommender;
import usecases.SongManager;

import java.util.List;

public class SongController {
    private final SongManager songManager;
    private final int recommendAmount = 9;
    public SongController(SongManager songManager){
        this.songManager = songManager;
    }
    public String Listen(String name){
        return songManager.getURL(name);
    }
    public List<String> getRecommend(Recommender recommender){
        return songManager.getRecommend(recommendAmount,recommender);
    }

    public String recommendSong(String songname, String receiverUsername) {
        if (songManager.getAllSongs().containsKey(songname)) {
            songManager.recommendSong(songname, receiverUsername);
            return "Successful.";
        } else {
            return "Song does not exist.";
        }
    }
    public float getRatting(String name){
        return songManager.displayCurrentRating(name);
    }
    public void rateAsong(String songName, float rating){
        songManager.rate(songName, rating);
    }

    public void saveData(){
        songManager.save();
    }

    public void addSong(String name, String url, String artist){
        songManager.addSong(name, url, artist);
    }
    public boolean has_song(String songName){
        return songManager.has_song(songName);
    }
}
