package commands;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;

import java.io.IOException;

/**
 * This class is responsible for exiting the program
 */
public class Exit implements ICommands {
    public Exit () {
    }

    /**
     * This method will let user exit the program.
     * @param state
     * @return a goodbye message to the user.
     * @throws IOException if the user has already logged out.
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        state.stopRunning();
        UserController userController = state.getLoginController().getUserController();// disgusting
        LoginController loginController = new LoginController(userController);
        loginController.LogOff(state.getUserProfile());
        state.getSongController().saveSongData();
        state.getNotificationController().saveNotificationData();
        try {
            Logout logout = new Logout();
            logout.executeCommand(state);
        } catch (Exception e) {
            return "Bye!";
        }
        return "Bye!";
    }
}
