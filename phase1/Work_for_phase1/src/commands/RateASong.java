package commands;

import controllers.ShellState;
import controllers.SongController;
import controllers.UserController;

import java.util.Scanner;

public class RateASong implements Commands{

    public RateASong() {
    }

    public String executeCommand(ShellState state) {
        try{
            if (state.getUserProfile().getIsSignedIn()){
                SongController songController = state.getSongController();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Which song do you want to rate?");
                String songName = scanner.nextLine();
                if (songController.has_song(songName)){
                    System.out.print("out of 5, what would you rate this song?");
                    String rating = scanner.nextLine();
                    float f = Float.parseFloat(rating);
                    songController.rateAsong(songName, f);
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
