package driver;

import controllers.*;
import usecases.IGateWay;
import usecases.NotificationCenter;
import usecases.SongManager;
import usecases.UserManager;

import java.io.IOException;

public class LoadData {
    // we will use this class to load necessary data

    public LoadData() {
    }

    public ShellState loadCurrentData() throws IOException, ClassNotFoundException {

        IGateWay g = new GateWay();
        NotificationCenter notificationCenter = new NotificationCenter(g);
        UserManager userManager = new UserManager(g);
        SongManager songManager = new SongManager(g);
        userManager.read();
        songManager.read();
        notificationCenter.read();
        SongController songController = new SongController(songManager);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        NotificationController notificationController = new NotificationController(songController, notificationCenter);
        return new ShellState(loginController, songController, notificationController);
    }


}
