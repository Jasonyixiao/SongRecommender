package usecases;

import entities.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<String> getRecommand(int amount){
        ArrayList<Song> result = new ArrayList<>();
        for(Song s : allSongs.values()){
            if(result.size()<amount){
                result.add(s);
            }else{
                replaceSmallerRating(result,s);
            }
        }
        ArrayList<String> trueResult = new ArrayList<>();
        for(Song s: result){
            trueResult.add(s.getName());
        }
        return trueResult;
    }
    private void replaceSmallerRating(List<Song> l, Song newSong){
        Song s = l.get(0);
        for (Song song: l) {
            if(song.getAvgRating()<s.getAvgRating()){
                s = song;
            }
        }
        if(s.getAvgRating()< newSong.getAvgRating()){
            l.remove(s);
            l.add(newSong);
        }
    }
    public String getURL(String name){
        return allSongs.get(name).getSongUrl();
    }
}
