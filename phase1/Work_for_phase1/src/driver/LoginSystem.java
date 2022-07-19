package driver;

import commands.CommandController;
import commands.Commandbuilder;
import commands.Commands;
import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import controllers.SongController;
import usecases.UserManager;
import usecases.SongManager;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
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
        SongManager songManager = new SongManager(g);
        userManager.read();
        songManager.read();
        SongController songController = new SongController(songManager);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        ShellState shellState = new ShellState(loginController,songController);

        Scanner input = new Scanner(System.in);
        Commandbuilder commandbuilder = new Commandbuilder();
        // CommandController command = new CommandController();  we can use the get method from this class to get a map with all the commands in it
        // HashMap<String, Commands> commandMap = command.getCommandMap(); // This is the map with all the commands in it
        while (shellState.getIsRunning()) {
            // when the user is not logged in, the user only have choices 000(register), 001(login), 003(exit).
            System.out.println("Enter your command, please refer to the README file for valid inputs.");
            String userCommand = input.nextLine();
            Commands command = commandbuilder.getCommand(userCommand);
            if (command != null){
                String result = command.executeCommand(shellState);
                System.out.println(result);
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

    //private static void commendChoice(String userCommand) {
    //    if (userCommand == "001") {

    //        Scanner input = new Scanner(System.in);
    //        System.out.println("Enter your command, " +
    //                "enter 008 to rate song, " +
    //                "009 to recommend, " +
    //                "010 to search songs," +
    //                "011 to search artist");
    //        String userCommand2 = input.nextLine();

    //        if (userCommand2 == "008") {
    //            return ();
    //        }
    //        else if (userCommand2 == "009") {
    //            return ();
    //        }
    //        else if (userCommand2 == "010") {

    //        }

    //        else if (userCommand2 == "011") {

    //        }

    //        else {}
    //    }

   // }

}