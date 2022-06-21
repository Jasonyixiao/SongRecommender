package shell.commands;

import controllers.IUserController;
import shell.IShellState;

import java.util.List;
import java.util.Scanner;

public class Register extends Command {

    public Register()
    {
        super(0,0);
    }
    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:  ");
        String username = scanner.nextLine();
        System.out.print("Password:  ");
        String password = scanner.nextLine();

        IUserController userController = shellState.getUserController();
        boolean success = userController.createNormalUser(shellState.getUserProfile(), username, password);
        if(success)
        {
            return "User created";
        }
        else
        {
            return "User creation failed";
        }
    }
}
