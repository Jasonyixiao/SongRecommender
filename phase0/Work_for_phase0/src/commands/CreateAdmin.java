package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

public class CreateAdmin implements Commands{

    public CreateAdmin() {
    }

    public String executeCommand(ShellState state) {
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                UserController userController = state.getLoginController().getUserController(); // disgusting
                String myUsername = state.getUserProfile().getUsername();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the Username of the Person You Want to promote:  ");
                String otherUsername = scanner.nextLine();
                return userController.createAdminUser(myUsername, otherUsername);
            } else {
                return "Please Login First.";
            }
        } catch (Exception e) {
            return "Please Login First";
        }
    }
}
