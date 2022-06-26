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
        UserController userController = state.getLoginController().getUserController(); // disgusting
        List<String> history =  userController.getLogInHistory(state.getUserProfile().getUsername());
        for (String item : history) {
            System.out.println(item);
        }
        return "";
    }
}
