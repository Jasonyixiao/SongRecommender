package commands;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;

import java.io.IOException;

/**
 *  This class is responsible for logging out a user.
 */
public class Logout implements Commands{
    public Logout() {
    }

    /**
     * This method will log out a user
     * @param state is the current state of the user.
     * @return whether the user has succeeded. Or return further instructions if the user did not succeed.
     * @throws IOException if the user didn't log in.
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                UserController userController = state.getLoginController().getUserController();// disgusting
                LoginController loginController = new LoginController(userController);
                loginController.LogOff(state.getUserProfile());
                state.getSongController().saveSongData();
                state.getNotificationController().saveNotificationData();
                return "You Are Logged Off!";
            } else {
                return "You are not logged in.";
            }
        } catch (Exception e) {
            return "You are not logged in.";
        }
    }
}
