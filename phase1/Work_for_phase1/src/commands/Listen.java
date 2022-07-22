package commands;

import controllers.ShellState;
import controllers.SongController;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is responsible for letting users listen to a song.
 */
public class Listen implements Commands {

    public Listen(){

    }

    /**
     * This method will prompt user to listen to a song  of user's choice.
     * @param state is the current state of the program.
     * @return the url of the song and messages about whether the user has succeeded.
     *         Or return further instructions if the user did not succeed.
     * @throws IOException if the user did not log in.
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        try{
            if (state.getUserProfile().getIsSignedIn()){
                Scanner scanner = new Scanner(System.in);
                System.out.print("What song do you want to listen to?");
                String songName = scanner.nextLine() ;
                SongController songController = state.getSongController();
                if (songController.hasSong(songName)){
                    String url = songController.listen(songName);
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
