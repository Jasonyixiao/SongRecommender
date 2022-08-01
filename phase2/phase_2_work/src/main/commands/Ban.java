package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

/**
 * This Class is responsible for banning a normal user.
 */
public class Ban implements ICommands {
    public Ban() {
    }

    /**
     * This method will prompt an admin user ban a normal user.
     * @param state is the current state of the program.
     * @return whether the admin user has successfully completed their operation, and future instruction.
     */
    public String executeCommand(ShellState state) {
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                UserController userController = state.getLoginController().getUserController(); // disgusting
                String myUsername = state.getUserProfile().getUsername();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the Username of the Person You Want to ban:  ");
                String otherUsername = scanner.nextLine();
                return userController.banUser(myUsername, otherUsername);
            } else {
                return "Command Failed";
            }
        } catch (Exception e) {
            return "Please Login First";
        }
    }
}
