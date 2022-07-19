package commands;

import controllers.ShellState;
import controllers.SongController;

import java.io.IOException;
import java.util.Scanner;

public class RecommendSongToUser implements Commands {
    public RecommendSongToUser () {

    }

    @Override
    public String executeCommand(ShellState state) throws IOException {
        //Todo currently we haven't dealt with the case where the username user input is invalid.
        // we can do this in song manager possibly.
        // we also need to add a line tof code that always checks notification when user first logs in
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                SongController songController = state.getSongController();
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the song name you wish to share: ");
                String songname = sc.nextLine();
                System.out.println("Enter the person's username you wish to share the song to: ");
                String username = sc.nextLine();
                return songController.recommendSong(songname, username);
            } else {
                return "please Login first.";
            }
        } catch (Exception e) {
            return "please Login first.";
        }
    }
}
