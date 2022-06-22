package shell.commands;

import controllers.IUserController;
import shell.IShellState;
import shell.constants.CommandException;

import java.util.List;
import java.util.Scanner;

public class User extends Command{

    public User()
    {
        super(2, 2);
    }
    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {
        IUserController userController = shellState.getUserController();
        String subCommand = arguments.get(0);
        String username = arguments.get(1);
        if(subCommand.equals("adduser"))
        {
            String password = ScanPassword();
            userController.createNormalUser(shellState.getUserProfile(), username, password);
            return "Added " + username;
        }
        if(subCommand.equals("addadmin")) {
            String password = ScanPassword();
            userController.createAdminUser(shellState.getUserProfile(), username, password);
            return "Added Admin " + username;
        }
        if(subCommand.equals("ban"))
        {
            userController.banUser(shellState.getUserProfile(), username);
            return "Banned " + username;
        }
        if(subCommand.equals("delete"))
        {
            userController.deleteUser(shellState.getUserProfile(), username);
            return "Deleted " + username;
        }
        return "Syntax Error";
    }

    private String ScanPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("New Password:  ");
        return scanner.nextLine();
    }
}
