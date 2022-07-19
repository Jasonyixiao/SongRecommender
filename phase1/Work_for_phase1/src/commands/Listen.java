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
        try{
            if (state.getUserProfile().getIsSignedIn()){
                Scanner scanner = new Scanner(System.in);
                System.out.print("What song do you want to listen to?");
                String songName = scanner.nextLine() ;
                SongController songController = state.getSongController();
                if (songController.has_song(songName)){
                    String url = songController.Listen(songName);
                    return "here is the spotify url of the song: " + url;
                }else{
                    return "No such song in the system";
                }

            }
            else {
                return "Please Login First.";
            }
        } catch (Exception e){
            return "Please Login First.";
        }
    }
}
