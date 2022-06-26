package commands;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import controllers.UserProfile;
import driver.GateWay;
import usecases.UserManager;

import java.io.IOException;

public class Logout extends Commands{
    public Logout() {
    }

    @Override
    public String executeCommand(ShellState state) throws IOException {
        UserController userController = state.getLoginController().getUserController();// disgusting
        LoginController loginController = new LoginController(userController);
        loginController.LogOff(state.getUserProfile());
        return "You Are Logged Off!";
    }
}
