package commands;

import controllers.ShellState;
import controllers.UserController;

import java.util.Scanner;

public class Register implements Commands{
    public Register () {

    }

    public String executeCommand(ShellState state) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name:  ");
        String username = scanner.nextLine() ;
        System.out.print("Enter Your Desired Password:  ");
        String password = scanner.nextLine();
        UserController userController = state.getLoginController().getUserController(); // very disgusting
        return userController.createNormalUser(username, password);
    }
}
