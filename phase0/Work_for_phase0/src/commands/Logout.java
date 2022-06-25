package commands;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import controllers.UserProfile;
import driver.GateWay;
import usecases.UserManager;

public class Logout extends Commands{
    public Logout() {
    }

    @Override
    public String executeCommand(ShellState state) {
        UserController userController = new UserController(new UserManager(new GateWay())); // disgusting
        LoginController loginController = new LoginController(userController);
        loginController.LogOff(state.getUserProfile());
        return "You Are Logged Off!";
    }
}
