import driver.GateWay;

import entities.Song;
import org.junit.*;
import recommendStrategy.Recommender;
import recommendStrategy.recommendByAvgRating;
import usecases.IGateWay;
import usecases.SongManager;


import static org.junit.Assert.*;
public class SongTest {
    @Test
    public void testSong(){
        IGateWay g = new GateWay();
        Song u0 = new Song("https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","song1","artist");
        SongManager userManager = new SongManager(g);
    }
    @Test
    // test adding a new song
    public void testAddSong(){
        IGateWay g = new GateWay();
        Song u0 = new Song("https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","song1","artist");
        SongManager songManager = new SongManager(g);
        songManager.addSong("song1","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        assertTrue(songManager.hasSong("song1"));
    }
    @Test
    // test the rating system
    public void testRating(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        songManager.addSong("song1","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        songManager.rate("song1",5);
        assertEquals(5, songManager.displayCurrentRating("song1"), 0.0);
        songManager.rate("song1",4);
        assertEquals(4.5, songManager.displayCurrentRating("song1"), 0.0);

    }

    @Test
    // test the listening system
    public void testListen(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        songManager.addSong("song1","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        assertEquals("https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19",songManager.listen("song1"));

    }

    @Test
    // test the recommending songs system
    public void testRecommend(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        Recommender r = new recommendByAvgRating();
        songManager.addSong("As It Was",
                "https://open.spotify.com/album/2pqdSWeJVsXAhHFuVLzuA8?highlight=spotify:track:4LRPiXqCikLlN15c3yImP7", "Harry Styles");
        songManager.addSong("Running Up That Hill", "https://open.spotify.com/track/29d0nY7TzCoi22XBqDQkiP?si=9b050067fe704e83",
                "Kate Bush");
        songManager.addSong("Me Porto Bonito", "https://open.spotify.com/track/6Sq7ltF9Qa7SNFBsV5Cogx?si=8cbf4d2a2ad3411a", "Bad Bunny, Chencho Corleone");
        songManager.addSong("Glimpse of Us","https://open.spotify.com/track/6xGruZOHLs39ZbVccQTuPZ?si=6b529f649ac04806","Joji" );
        songManager.addSong("Efecto", "https://open.spotify.com/track/5Eax0qFko2dh7Rl2lYs3bx?si=cbd7e80be54f4cf1", "Bad Bunny");
        songManager.addSong("GIVENCHY", "https://open.spotify.com/track/2bbwjxA68m9PHZFWgF1fze?si=ab6bf33bfd224f9f", "Duki");
        songManager.addSong("Bad Habit", "https://open.spotify.com/track/4k6Uh1HXdhtusDW5y8Gbvy?si=af799da49fab456c","Steve Lacy");
        songManager.addSong("I Ain't Worried", "https://open.spotify.com/track/4h9wh7iOZ0GGn8QVp4RAOB?si=3c6cd25339b44b8e", "OneRepublic");
        songManager.addSong("First Class", "https://open.spotify.com/track/0wHFktze2PHC5jDt3B17DC?si=89f658394a5a463e", "Jack Harlow");
        float i = 0;
        for(String songName: songManager.allSongNames()){
            songManager.rate(songName, i);
            i += 0.5;
        }
        assertEquals(songManager.allSongNames(),songManager.getRecommend(9, r));
    }

}
