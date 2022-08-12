package driver;

import commands.CommandFactory;
import commands.ICommands;
import controllers.*;
import usecases.IGateWay;
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

    public void run() throws IOException, ClassNotFoundException {
        loadInitialSongs();
        ShellState shellState = loadCurrentData();
        Scanner input = new Scanner(System.in);
        CommandFactory commandFactory = new CommandFactory();
        while (shellState.getIsRunning()) {
            // when the user is not logged in, the user only have choices 000(register), 001(login), 003(exit).
            System.out.println("Enter your command, please refer to the README file for valid inputs.");
            String userCommand = input.nextLine();
            ICommands command = commandFactory.getCommand(userCommand);
            if (command != null) {
                String result = command.executeCommand(shellState);
                System.out.println(result);
            }
        }
    }

    private ShellState loadCurrentData() throws ClassNotFoundException {
        IGateWay g = new GateWay();
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

    //Ideally, this method will only get run once, this is just a "hard coded" method for adding the initial songs into
    //the program.
    public void loadInitialSongs() throws IOException {
        GateWay g = new GateWay();
        SongController songController = new SongController(new SongManager(g));
        songController.addSong("As It Was",
                "https://www.youtube.com/watch?v=H5v3kku4y6Q", "Harry Styles");
        songController.addSong("Running Up That Hill", "https://www.youtube.com/watch?v=wp43OdtAAkM",
                "Kate Bush");
        songController.addSong("Me Porto Bonito", "https://www.youtube.com/watch?v=saGYMhApaH8", "Bad Bunny, Chencho Corleone");
        songController.addSong("Glimpse of Us","https://www.youtube.com/watch?v=NgsWGfUlwJI","Joji" );
        songController.addSong("Efecto", "https://www.youtube.com/watch?v=Nk8C9FdCdJQ", "Bad Bunny");
        songController.addSong("GIVENCHY", "https://www.youtube.com/watch?v=ymvYySd_P2E", "Duki");
        songController.addSong("Bad Habit", "https://www.youtube.com/watch?v=orJSJGHjBLI","Steve Lacy");
        songController.addSong("I Ain't Worried", "https://www.youtube.com/watch?v=mNEUkkoUoIA", "OneRepublic");
        songController.addSong("First Class", "https://www.youtube.com/results?search_query=First+Class", "Jack Harlow");
        songController.addSong("Ghost", "https://www.youtube.com/watch?v=Fp8msa5uYsc", "Justin Bieber");
        songController.addSong("Shivers", "https://www.youtube.com/watch?v=Il0S8BoucSA", "Ed Sheeran");
        songController.addSong("Woman", "https://www.youtube.com/watch?v=yxW5yuzVi8w", "Doja Cat");
        songController.addSong("Dandelions", "https://www.youtube.com/watch?v=taYxyE34jjY", "Ruth B.");
        songController.saveSongData();
    }


}
