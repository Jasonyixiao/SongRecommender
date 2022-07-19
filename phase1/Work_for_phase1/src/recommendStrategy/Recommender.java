package recommendStrategy;

import entities.Song;

import java.util.HashMap;
import java.util.List;

public interface Recommender {
    public List<String> getRecommend(int amount, HashMap<String, Song> allSongs);
}
