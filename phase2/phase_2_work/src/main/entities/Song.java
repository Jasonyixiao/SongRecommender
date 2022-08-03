package entities;

import java.io.Serializable;

/**
 * This class represents a song in our system
 */
public class Song implements Serializable {

    private final String songUrl;

    private float totalpoints;

    private final String Name;

    private final String artist;

    private int numRatedPeople = 0;

    /**
     * Constructor of a song, stores the song name, Spotify link of the song and the singer.
     * @param url is the Spotify link of the song.
     * @param name is the songname.
     * @param artist is the singer.
     */
    public Song(String
                        url, String name, String artist){
        songUrl = url;
        this.artist = artist;
        Name = name;
    }

    /**
     * This method will let a user rate the song with point.
     * @param point is rating the user gives.
     */
    public void rate(float point){
        totalpoints += point;
        numRatedPeople ++;
    }

    /**
     * Getter for SongUrl.
     * @return the Spotify link for the song.
     */
    public String getSongUrl(){
        return songUrl;
    }

    /**
     * Getter for Name;
     * @return the song name.
     */
    public String getName(){
        return Name;
    }

    /**
     * Getter for artist
     * @return the singer of the song.
     */
    public String getArtist(){
        return artist;
    }

    /**
     * Calculates the average rating of this song.
     * @return the average rating of this song.
     */
    public float getAvgRating(){
        return totalpoints/numRatedPeople;
    }
}
