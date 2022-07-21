package driver;

import commands.CommandFactory;
import commands.Commands;
import controllers.LoginController;
import controllers.ShellState;
import controllers.SongController;
import controllers.UserController;
import usecases.SongManager;
import usecases.UserManager;

import java.io.IOException;
import java.util.Scanner;
/**
 * This is the Shell that prompts user for input
 */
public class TopNineRunner {

    public TopNineRunner(){

    }

    public void run() throws IOException {
        //File f = new File(driver.GateWay.userFile);
        //System.out.println(f.exists());
        GateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        SongManager songManager = new SongManager(g);
        userManager.read();
        songManager.read();
        SongController songController = new SongController(songManager);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        ShellState shellState = new ShellState(loginController, songController);

        Scanner input = new Scanner(System.in);
        CommandFactory commandFactory = new CommandFactory();
        while (shellState.getIsRunning()) {
            // when the user is not logged in, the user only have choices 000(register), 001(login), 003(exit).
            System.out.println("Enter your command, please refer to the README file for valid inputs.");
            String userCommand = input.nextLine();
            Commands command = commandFactory.getCommand(userCommand);
            if (command != null) {
                String result = command.executeCommand(shellState);
                System.out.println(result);
            }
        }
    }
}
