package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

public class Delete extends Commands {

    public Delete() {
    }

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