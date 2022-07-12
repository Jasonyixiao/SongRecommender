package commands;

import controllers.ShellState;
import controllers.UserController;
import java.util.List;

public class History implements Commands{

    public History () {

    }

    public String executeCommand(ShellState state) {
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                UserController userController = state.getLoginController().getUserController(); // disgusting
                List<String> history = userController.getLogInHistory(state.getUserProfile().getUsername());
                for (String item : history) {
                    System.out.println(item);
                }
                return "";
            } else {
                return "Please Login First.";
            }
        } catch (Exception e) {
            return "Please Login First.";
        }
    }
}
