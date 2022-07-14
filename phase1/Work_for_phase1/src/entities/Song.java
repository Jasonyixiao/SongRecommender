package entities;
/**
 * This class represents a song in our system
 */
public class Song {

    private String songUrl;

    private float totalpoints;

    private String Name;

    private String artist;

    private int numRatedPeople = 0;

    public Song(String url, String name, String artist){
        songUrl = url;
        this.artist = artist;
        Name = name;
    }

    public void addRatedPeople(){
        numRatedPeople ++;
    }

    public void addPoints(float point){
        totalpoints += point;
    }

    public String getSongUrl(){
        return songUrl;
    }
    public String getName(){
        return Name;
    }
    public String getArtist(){
        return artist;
    }
    public float getAvgRating(){
        return totalpoints/numRatedPeople;
    }
}
