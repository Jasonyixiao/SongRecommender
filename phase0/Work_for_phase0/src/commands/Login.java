package commands;

import controllers.*;


import java.util.Scanner;

public class Login extends Commands{
    // we want to use the username and password user inputs to login the user, but at the same time make login method
    // return an userprofile, so that the next time user tries to do something we do not have to ask for username and
    // password again.
    public Login() {

    }
    public String executeCommand(ShellState shellState) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:  ");
        String username = scanner.nextLine();
        System.out.print("Password:  ");
        String password = scanner.nextLine();
        UserController userController = shellState.getLoginController().getUserController();  // disgusting
        LoginController loginController = new LoginController(userController);
        UserProfile userContext = loginController.Login(username,password);
        shellState.setUserProfile(userContext);
        if (userContext != null) {
            shellState.setIsSignedIn();
            return "Success";
        } else {
            return "Login Failed";
        }
    }
}
