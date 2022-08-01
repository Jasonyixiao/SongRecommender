package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

/**
 * This Class is responsible for registering new user
 */
public class Register implements ICommands {
    public Register () {

    }

    /**
     * This method will prompt new users to register a new account.
     * @param state is the current state of the program.
     * @return message regarding outcome of registering a new account.
     */
    public String executeCommand(ShellState state) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Username:  ");
        String username = scanner.nextLine() ;
        System.out.print("Enter Your Desired Password:  ");
        String password = scanner.nextLine();
        UserController userController = state.getLoginController().getUserController(); // very disgusting
        return userController.createNormalUser(username, password);
    }
}
