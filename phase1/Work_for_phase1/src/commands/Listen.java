package commands;

import controllers.ShellState;
import controllers.SongController;
import controllers.UserController;

import java.io.IOException;
import java.util.Scanner;

public class Listen implements Commands {

    public Listen(){

    }
    @Override
    public String executeCommand(ShellState state) throws IOException {
        if (state.getUserProfile().getIsSignedIn()){
            Scanner scanner = new Scanner(System.in);
            System.out.print("What song do you want to listen to?");
            String songName = scanner.nextLine() ;
            SongController songController = state.getSongController();
            return "here is the spotify url of the song: songController.Listen(songName)";
        }
        else {
            return "Please Login First.";
        }
    }
}
