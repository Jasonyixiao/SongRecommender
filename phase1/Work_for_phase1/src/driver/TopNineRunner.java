package driver;

import commands.CommandFactory;
import commands.Commands;
import controllers.*;
import usecases.NotificationCenter;
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
        ShellState shellState = load_current_data();
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

    private ShellState load_current_data(){
        GateWay g = new GateWay();
        NotificationCenter notificationCenter = new NotificationCenter(g);
        UserManager userManager = new UserManager(g);
        SongManager songManager = new SongManager(g);
        userManager.read();
        songManager.read();
        notificationCenter.read();
        SongController songController = new SongController(songManager);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        NotificationController notificationController = new NotificationController(songController,notificationCenter);
        return new ShellState(loginController, songController, notificationController);

    }


}
