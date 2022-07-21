package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

/**
 * This class is responsible for admin user to create another admin user.
 */
public class CreateAdmin implements Commands{

    public CreateAdmin() {
    }

    /**
     * This method will prompt admin user to promote a normal user to admin user.
     * @param state is the current state of the program
     * @return whether the admin user has succeeded. Or return further instructions if the adminuser did not succeed.
     */
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
