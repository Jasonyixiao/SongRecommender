package recommendStrategy;

import entities.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class recommendByAvgRating implements Recommender {
    public recommendByAvgRating(){}


    @Override
    public List<String> getRecommend(int amount, HashMap<String, Song> allSongs) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : allSongs.values()) {
            if (result.size() < amount) {
                result.add(s);
            } else {
                replaceSmallerRating(result, s);
            }
        }
        ArrayList<String> trueResult = new ArrayList<>();
        for (Song s : result) {
            trueResult.add(s.getName());
        }
        return trueResult;
    }

    private void replaceSmallerRating(List<Song> l, Song newSong) {
        Song s = l.get(0);
        for (Song song : l) {
            if (song.getAvgRating() < s.getAvgRating()) {
                s = song;
            }
        }
        if (s.getAvgRating() < newSong.getAvgRating()) {
            l.remove(s);
            l.add(newSong);
        }
    }
}
