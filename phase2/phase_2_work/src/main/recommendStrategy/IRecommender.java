package recommendStrategy;

import entities.Song;

import java.util.Collection;
import java.util.List;
/**
 *  Interface for recommenders that can recommend songs.
 */

public interface IRecommender {
    List<String> getRecommend(int amount, Collection<Song> allSongs);
}
