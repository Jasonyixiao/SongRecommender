package controllers;

import recommendStrategy.IRecommender;
import usecases.SongManager;

import java.io.IOException;
import java.util.List;

/**
 * This Class is responsible for calling the necessary methods for user to perform song-related tasks
 */
public class SongController {
    private final SongManager songManager;

    private final int recommendAmount = 9;

    /**
     * Constructor for the SongController. Stores songManager in.
     * @param songManager is responsible for changing information about a Song.
     */
    public SongController(SongManager songManager){
        this.songManager = songManager;
    }

    /**
     * This method will provide user with an url of the song.
     * @param name is the name of the song the user wants to listen.
     * @return the Spotify link for the song.
     */
    public String listen(String name){
        return songManager.listen(name);
    }

    /**
     * This method will return the recommended songs in this program.
     * @param recommender decides the recommending algorithm we will use.
     * @return list of song names that are recommended.
     */
    public List<String> getRecommend(IRecommender recommender){
        return songManager.getRecommend(recommendAmount,recommender);
    }

//    /**
//     * This method will recommend a song to a specific user via username.
//     * @param songname is the name of the song the user wants to recommend.
//     * @param receiverUsername is the username of which the user wants to recommend to.
//     * @return a message of whether the task is performed successfully.
//     */
//    public String recommendSong(String songname, String receiverUsername) {
//        if (songManager.getAllSongs().containsKey(songname)) {
//            songManager.recommendSong(songname, receiverUsername);
//            return "Successful.";
//        } else {
//            return "Song does not exist.";
//        }
//    }

    /**
     * This method will show user the current rating of the specific song.
     * @param name is the song name of the song.
     * @return the rating of the song.
     */
    public float getRatting(String name){
        return songManager.displayCurrentRating(name);
    }

    /**
     * This method will give a song with songName a rating.
     * @param songName is the name of the song being rated.
     * @param rating is the rating that the user is planning to give.
     */
    public void rateAsong(String songName, float rating){
        songManager.rate(songName, rating);
    }

    /**
     * This method will save the song data.
     */
    public void saveSongData(){
        try {
            songManager.save();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * This method will call methods necessary to add a song to the system.
     * @param name is the name of song being added.
     * @param url is the Spotify link of the song.
     * @param artist is the singer of the song.
     */
    public void addSong(String name, String url, String artist){
        songManager.addSong(name, url, artist);
    }

    /**
     * This method will check whether the song with songName is in the system.
     * @param songName is the name of song the user is looking for.
     * @return true iff the system contains the song.
     */
    public boolean hasSong(String songName){
        return songManager.hasSong(songName);
    }

    /**
     * This method returns the song names of all the songs in the system.
     * @return  the song names of all the songs in the system.
     */
    public List<String> allSongNames(){
        return songManager.allSongNames();
    }
    /**
     * This method will add a song to the system.
     * @param name is the songname.
     * @param url is the Spotify link to the song.
     * @param artist is the singer of the song.
     */

}
