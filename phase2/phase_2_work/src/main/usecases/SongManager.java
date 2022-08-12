package usecases;


import entities.Song;
import recommendStrategy.IRecommender;

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



    /**
     * Constructor for SongManager, initialize and stores all the songs in the system, and store
     * an instance of IGateWay.
     * @param g is the instance of IGateWay we use to save data..
     */
    public SongManager(IGateWay g) {
        this.allSongs = new HashMap<>();
        this.gateWay = g;

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
     * @param point is the rating the user wants to give.(out of 5)
     * @return true iff the user's rating is between 1-5 and the system contains the song.
     */
    public boolean rate(String songName, float point){
        if (allSongs.get(songName)!= null && point <= 5.0 && point >= 0.0 ){
            allSongs.get(songName).rate(point);
            return true;

        }else{
            return false;
        }
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
    public List<String> getRecommend(int amount, IRecommender recommender) {
        return recommender.getRecommend(amount, allSongs.values());
    }



    /**
     * This method will read in all song's data from local, and save it in allSongs.
     * @throws  IOException if error reading from file.
     */
    public void read() throws ClassNotFoundException {

            allSongs = gateWay.readSong();
    }

    /**
     * This method will return the artist of the given song.
     * @param songName the song name.
     * @return return the name of the artist.
     */
    public String getAuthor(String songName) {
        Song song = allSongs.get(songName);
        return song.getArtist();
    }


    /**
     * This method will save allSongs data into the songFile.
     * @throws  IOException if error finding directory.
     */
    public void save() throws IOException {
        gateWay.save(allSongs, gateWay.getSongFile());
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

