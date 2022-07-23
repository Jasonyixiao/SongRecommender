package usecases;


import entities.Song;
import recommendStrategy.Recommender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * This class will allow the system users to do stuff with a song.
 */
public class SongManager {

    private HashMap<String, Song> allSongs;

    private final IGateWay gateWay;



    /**
     * Constructor for SongManager, initialize and stores all the songs in the system, and store
     * an instance of IGateWay.
     * @param g is the instance of IGateWay we use to save data..
     */
    public SongManager(IGateWay g) {
        this.allSongs = new HashMap<>(9999);
        this.gateWay = g;

    }


    /**
     * Getter for all Songs.
     * @return all songs in the system in the form of songname to song key-value pairs.
     */
    public HashMap<String, Song> getAllSongs() {
        return allSongs;
    }


    /**
     * This method will add a song to the system.
     * @param name is the songname.
     * @param url is the Spotify link to the song.
     * @param artist is the singer of the song.
     */
    public void addSong(String name, String url, String artist) {
        allSongs.put(name, new Song(url, name, artist));
    }



    /**
     * This method will let user to rate a song.
     * @param songName is the name of the song.
     * @param point is the rating the user wants to give.
     */
    public void rate(String songName, float point) {
        allSongs.get(songName).rate(point);
    }


    /**
     * This method will provide Spotify link of the song for user to listen.
     * @param songName is the name of the song.
     * @return the Spotify link of the song.
     */
    public String listen(String songName){ // we will return the url for now
        return allSongs.get(songName).getSongUrl();
    }


    /**
     * This method will return the current rating of the song specified by songName.
     * @param songName is the name of song user wants to check rating of.
     * @return the current average rating of the song.
     */
    public float displayCurrentRating(String songName) {
        return allSongs.get(songName).getAvgRating();
    }


    /**
     * This method will recommend a certain amount of songs using the algorithm implemented in the recommender.
     * @param amount is the number of songs the user wish to recommend.
     * @param recommender specifies which recommending algorithm we will user.
     * @return list of song names that are recommended.
     */
    public List<String> getRecommend(int amount, Recommender recommender) {
        return recommender.getRecommend(amount, allSongs.values());
    }



    /**
     * This method will read in all song's data from local, and save it in allSongs.
     */
    public void read() {
        try {
            allSongs = gateWay.read_song();
        } catch (ClassNotFoundException ignored) {
        }
    }


    /**
     * This method will save allSongs data into the songFile.
     */
    public void save() {
        try {
            gateWay.save(allSongs, gateWay.getSongFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * This method checks whether a song is in the system.
     * @param songName is the name of song we are checking.
     * @return true iff the song is in the system.
     */
    public boolean hasSong(String songName){
        return allSongs.get(songName) != null;
    }

    /**
     * This method returns the song names of all the songs in the system.
     * @return  the song names of all the songs in the system.
     */
    public List<String> allSongNames(){
        return new ArrayList<>(allSongs.keySet());

    }
}

