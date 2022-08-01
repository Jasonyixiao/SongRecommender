package commands;

import controllers.ShellState;
import controllers.UserController;

import java.io.IOException;
import java.util.List;

/**
 * This class is responsible for presenting the login history for the user.
 */
public class History implements ICommands {

    public History () {

    }

    /**
     * This method will print out the login history of the user.
     * @param state is the current state of the program
     * @return whether the user has succeeded. Or return further instructions if the user did not succeed.
     * @throws IOException if the user didn't log in.
     */

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
