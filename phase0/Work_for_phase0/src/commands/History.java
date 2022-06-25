package commands;

import controllers.ShellState;
import controllers.UserController;
import driver.GateWay;
import usecases.UserManager;

import java.util.Date;
import java.util.List;

public class History extends Commands{

    public History () {

    }

    public String executeCommand(ShellState state) {
        UserController userController = new UserController(new UserManager(new GateWay())); // disgusting
        List<String> history =  userController.getLogInHistory(state.getUserProfile().getUsername());
        for (String item : history) {
            System.out.println(history);
        }
        return "";
    }
}
