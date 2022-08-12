import controllers.SongController;
import driver.GateWay;

import entities.Song;
import org.junit.*;
import recommendStrategy.IRecommender;
import recommendStrategy.RecommendByAvgRating;
import usecases.IGateWay;
import usecases.SongManager;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test methods that modify information regarding songs.
 */
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
        SongController songController = new SongController(songManager);
        songController.addSong("song1","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        assertTrue(songManager.hasSong("song1"));
    }
    @Test
    // test the rating system
    public void testRating(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song1","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        try {
            songController.rateASong("song1",5);
            assertEquals(5, songController.getRatting("song1"), 0.0);
            songController.rateASong("song1",4);
            assertEquals(4.5, songController.getRatting("song1"), 0.0);
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    // test the listening system
    public void testListen(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song1","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        assertEquals("https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19",songController.listen("song1"));

    }

    @Test
    // test the recommending songs system
    public void testRecommend(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);

        IRecommender r = new RecommendByAvgRating();
        songController.addSong("As It Was",
                "https://open.spotify.com/album/2pqdSWeJVsXAhHFuVLzuA8?highlight=spotify:track:4LRPiXqCikLlN15c3yImP7", "Harry Styles");
        songController.addSong("Running Up That Hill", "https://open.spotify.com/track/29d0nY7TzCoi22XBqDQkiP?si=9b050067fe704e83",
                "Kate Bush");
        songController.addSong("Me Porto Bonito", "https://open.spotify.com/track/6Sq7ltF9Qa7SNFBsV5Cogx?si=8cbf4d2a2ad3411a", "Bad Bunny, Chencho Corleone");
        songController.addSong("Glimpse of Us","https://open.spotify.com/track/6xGruZOHLs39ZbVccQTuPZ?si=6b529f649ac04806","Joji" );
        songController.addSong("Efecto", "https://open.spotify.com/track/5Eax0qFko2dh7Rl2lYs3bx?si=cbd7e80be54f4cf1", "Bad Bunny");
        songController.addSong("GIVENCHY", "https://open.spotify.com/track/2bbwjxA68m9PHZFWgF1fze?si=ab6bf33bfd224f9f", "Duki");
        songController.addSong("Bad Habit", "https://open.spotify.com/track/4k6Uh1HXdhtusDW5y8Gbvy?si=af799da49fab456c","Steve Lacy");
        songController.addSong("I Ain't Worried", "https://open.spotify.com/track/4h9wh7iOZ0GGn8QVp4RAOB?si=3c6cd25339b44b8e", "OneRepublic");
        songController.addSong("First Class", "https://open.spotify.com/track/0wHFktze2PHC5jDt3B17DC?si=89f658394a5a463e", "Jack Harlow");
        float i = 0;
        for(String songName: songController.allSongNames()){
            try {
                songController.rateASong(songName, i);
            } catch (IOException e) {
                fail();
            }
            i += 0.5;
        }
        assertEquals(songController.allSongNames(),songController.getRecommend(r));
    }

    @Test
    // test getRatting
    public void testGetRating(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song123","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","artist");
        try {
            songController.rateASong("song123",5);
            assertEquals(5, songController.getRatting("song123"), 0.0);
        } catch (IOException e) {
            fail();
        }

    }

    @Test
    // test getSongAuthor
    public void testGetSongAuthor(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song123","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","harry");
        assertEquals("harry",songController.getSongAuthor("song123"));

    }

    @Test
    // test hasSong
    public void testHasSong(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song123","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","harry");
        assertTrue(songController.hasSong("song123"));
        assertTrue(!songController.hasSong("song"));
    }

    @Test
    // test allSongNames
    public void testAllSongNames(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song123","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","harry");
        songController.addSong("harry", "www.goo.com","jason");
        songController.addSong("jason", "213213", "dasd");
        List<String> expected  = new ArrayList<>();
        expected.add("song123");
        expected.add("harry");
        expected.add("jason");
        assertTrue(expected.containsAll(songController.allSongNames()) &&
                songController.allSongNames().containsAll(expected));

    }
    @Test
    public void testSaveAndReadSongData(){
        IGateWay g = new GateWay();
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        songController.addSong("song123","https://open.spotify.com/track/6Uj1ctrBOjOas8xZXGqKk4?si=1d62a803cf494c19","harry");
        try{songController.saveSongData();
        }catch (IOException e){
            fail();
        }  IGateWay g1 = new GateWay();
        SongManager songManager1 = new SongManager(g1);
        SongController songController1 = new SongController(songManager1);
        try{songManager1.read();
        }catch(ClassNotFoundException c){
            fail();
        }
        assertTrue(songController.hasSong("song123"));



    }


}
