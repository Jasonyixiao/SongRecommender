package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

/**
 * This Class is responsible for deleting a user.
 */
public class Delete implements ICommands {

    public Delete() {
    }

    /**
     * This method will prompt admin user to delete a normal user.
     * @param state is the current state of the user.
     * @return whether the admin user has succeeded. Or return further instructions if the admin user did not succeed.
     */
    public String executeCommand(ShellState state) {
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                UserController userController = state.getLoginController().getUserController(); // disgusting
                String myUsername = state.getUserProfile().getUsername();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the Username of the Person You Want to Delete:  ");
                String otherUsername = scanner.nextLine();
                return userController.deleteUser(myUsername, otherUsername);
            } else {
                return "Command Failed, Try Again.";
            }
        } catch (Exception e) {
            return "Please Login First.";
        }
    }
}