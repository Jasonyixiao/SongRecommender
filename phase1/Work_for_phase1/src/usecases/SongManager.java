package usecases;

import entities.Song;

import java.util.HashMap;

/**
 * This class will allow the system users to do stuff with a song.
 */
public class SongManager {

    private HashMap<String, Song> allSongs;



    public SongManager(){
        this.allSongs = new HashMap<>(9999);
    }


    public void addSong(String name, String url, String artist){
        allSongs.put(name,new Song(url, name, artist));
    }


    public void rate(String songName, float point){
        allSongs.get(songName).addPoints(point);
        allSongs.get(songName).addRatedPeople();
    }


    //public String listen(String songName){}
    //what do we do here?


    public float displayCurrentRating(String songName){
        return allSongs.get(songName).getAvgRating();
    }
}
