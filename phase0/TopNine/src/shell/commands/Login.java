package shell.commands;

import controllers.ILoginController;
import controllers.UserProfile;
import shell.IShellState;

import java.util.List;
import java.util.Scanner;

public class Login extends Command {

    public Login() {
        super(0, 0);
    }

    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:  ");
        String username = scanner.nextLine();
        System.out.print("Password:  ");
        String password = scanner.nextLine();

        ILoginController loginController = shellState.getLoginController();
        UserProfile loginUser = loginController.Login(username,password);
        if(loginUser != null)
        {
            shellState.setUserProfile(loginUser);
            return "Success";
        }
        else
            return "Login Failed.";
    }
}
