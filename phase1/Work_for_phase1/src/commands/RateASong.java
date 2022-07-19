package commands;

import controllers.ShellState;
import controllers.SongController;
import controllers.UserController;

import java.util.Scanner;

public class RateASong implements Commands{

    public RateASong() {
    }

    public String executeCommand(ShellState state) {
        SongController songController = state.getSongController();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which song do you want to rate?");
        String songName = scanner.nextLine();
        System.out.print("out of 5, what would you rate this song?");
        String rating = scanner.nextLine();
        float f = Float.parseFloat(rating);
        songController.rateAsong(songName, f);
        return "you successfully rated " + songName + " a " + rating + " .";

    }

}
