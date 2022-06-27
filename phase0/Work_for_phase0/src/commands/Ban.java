package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

public class Ban extends Commands{
    public Ban() {
    }

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
