package commands;

import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import controllers.UserProfile;
import driver.GateWay;
import usecases.UserManager;

import java.util.Scanner;

public class Register extends Commands{
    public Register () {

    }

    public String executeCommand(ShellState state) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Username:  ");
        String username = scanner.nextLine() ;
        System.out.print("Enter your Password:  ");
        String password = scanner.nextLine();
        UserController userController = state.getLoginController().getUserController(); // very disgusting
        return userController.createNormalUser(username, password);
    }
}
