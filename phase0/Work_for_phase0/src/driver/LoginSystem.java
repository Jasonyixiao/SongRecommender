package driver;

import commands.CommandController;
import commands.Commands;
import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import usecases.UserManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is the Shell that prompts user for input
 */
public class LoginSystem {


    public static void main(String[] args) throws IOException {
            //File f = new File(driver.GateWay.userFile);
            //System.out.println(f.exists());
        GateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        userManager.read();
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        ShellState shellState = new ShellState(loginController);

        Scanner input = new Scanner(System.in);
        CommandController command = new CommandController(shellState); // we can use the get method from this class to get a map with all the commands in it
        HashMap<String, Commands> commandMap = command.getCommandMap(); // This is the map with all the commands in it
        while (shellState.getIsRunning()){
            // when the user is not logged in, the user only have choices 000(register), 001(login), 003(exit).
            System.out.println("Enter your command, enter 000 to Register, 001 to login, " +
                    "002 to logout, 003 to Exit, 004 to check history" +
                    ", 005 to create Admin, 006 to delete a user");
            String userCommand = input.nextLine();
            if (commandMap.get(userCommand) != null) {
                String result = commandMap.get(userCommand).executeCommand(shellState);
                System.out.println(result);
            } else {
                System.out.println("Invalid Input, Try Again!");
            }
        }
//            GateWay g = new GateWay();
//            UserManager userManager = new UserManager(g);

//            userManager.createUser("aaa","bbb");
//            userManager.createUser("a", "b");
//            userManager.save();
//            UserManager n1 = new UserManager(g);
//            n1.read();
//            System.out.println(n1.getAllUsers());

            //m.create_admin_user("aaa","bbb");
            //System.out.println(m.getAllAdminUsers());
            //m.save();
            //AdminManager.admindata a = new AdminManager.admindata();

            //g.save(new AdminManager.admindata());



    }
}
