import controllers.*;
import driver.GateWay;
import org.junit.Test;
import usecases.IGateWay;
import usecases.NotificationCenter;
import usecases.SongManager;
import usecases.UserManager;

import java.io.IOException;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Test methods that modify information regarding notifications.
 */
public class NotificationTest {
    private ShellState loadData() {
        IGateWay g = new GateWay();
        NotificationCenter notificationCenter = new NotificationCenter(g);
        UserManager userManager = new UserManager(g);
        SongManager songManager = new SongManager(g);
        SongController songController = new SongController(songManager);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        NotificationController notificationController = new NotificationController(songController, notificationCenter);
        return new ShellState(loginController, songController, notificationController);
    }
    @Test
    public void testGetCurrentNotificationId(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        assert Objects.equals(shellState.getNotificationController().getCurrentNotificationId(), 1);
    }
    @Test
    public void testGetMessage(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        assert Objects.equals(shellState.getNotificationController().getMessage(
                "x",
                shellState.getNotificationController().getCurrentNotificationId()), "rec");
    }
    @Test
    public void testTotalNotification(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        assert Objects.equals(shellState.getNotificationController().getTotalNumMessage("x"), 2);
    }
    @Test
    public void testGetContent(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        assert Objects.equals(shellState.getNotificationController().getContent(
                "x",
                shellState.getNotificationController().getCurrentNotificationId()), "djiedij.idi");
    }
    @Test
    public void testGetSender(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        assert Objects.equals(shellState.getNotificationController().getSender(
                "x",
                shellState.getNotificationController().getCurrentNotificationId()), "jason");
    }
    @Test
    public void testGetNumNotification(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd",
                "x",
                "jason",
                "rec");
        assert Objects.equals(shellState.getNotificationController().getNumOfNewNotifications("x"), 1);
        assert Objects.equals(shellState.getNotificationController().getNumOfNewNotifications("jason"), 0);
    }
    @Test
    public void testRecommendSong(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("ded", "djiedij.idi", "uh");
        assert Objects.equals(shellState.getNotificationController().recommendSong(
                "ded",
                "jason",
                "x",
                "rec"), true);
    }
    @Test
    public void testSaveAndRead(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd1", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd1",
                "x",
                "jason",
                "rec");
        try {
            shellState.getNotificationController().saveNotificationData();
        } catch (IOException e) {
            fail();
        }
        IGateWay g = new GateWay();

        NotificationCenter notificationCenter= new NotificationCenter(g);
        try {
            notificationCenter.read();
        }catch ( ClassNotFoundException e){
            fail();
        }
        assertEquals(1, notificationCenter.getTotalNumNotifications("x"));

    }
    @Test
    //test getSongName
    public void testGetSongName(){
        ShellState shellState = loadData();
        shellState.getSongController().addSong("dd1", "djiedij.idi", "uh");
        shellState.getNotificationController().recommendSong(
                "dd1",
                "x",
                "jason",
                "rec");

        String name = shellState.getNotificationController().
                getSongName("x",shellState.getNotificationController().getCurrentNotificationId());
        assertEquals(name, "dd1");
    }




}
