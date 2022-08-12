package commands;

import controllers.ShellState;
import controllers.SongController;

import java.util.Scanner;

/**
 * This class is responsible for rating a song.
 */
public class RateASong implements ICommands {

    public RateASong() {
    }

    /**
     * This method will prompt users to rate a song.
     * @param state is the current state of the program.
     * @return whether the user has succeeded. Or return further instructions if the user did not succeed.
     *
     */
    public String executeCommand(ShellState state) {
        try{
            if (state.getUserProfile().getIsSignedIn()){
                SongController songController = state.getSongController();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Which song do you want to rate?");
                String songName = scanner.nextLine();
                if (songController.hasSong(songName)){
                    System.out.print("out of 5, what would you rate this song?");
                    String rating = scanner.nextLine();
                    float f = Float.parseFloat(rating);
                    songController.rateASong(songName, f);
                    return "you successfully rated " + songName + " a " + rating + " .";
                }else{
                    return "No such song in the system";
                }
            }
            else{
                return "Please Login First.";
            }
        }
        catch (Exception e){
            return "Please Login First.";
        }


    }

}
