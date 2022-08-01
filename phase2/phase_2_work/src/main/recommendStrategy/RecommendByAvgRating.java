package recommendStrategy;

import entities.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This Class is responsible for implementing one recommending strategy.
 */
public class RecommendByAvgRating implements IRecommender {
    public RecommendByAvgRating(){}

    /**
     * This method will recommend songs based on highest average ratings.
     * @param amount is the number of recommended songs.
     * @param allSongs is the collections of songs where we find recommended songs from.
     * @return a list of song names of recommended songs.
     */
    @Override
    public List<String> getRecommend(int amount, Collection<Song> allSongs) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : allSongs) {
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
