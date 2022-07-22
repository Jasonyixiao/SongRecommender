package commands;

import controllers.RecommendController;
import controllers.ShellState;
import controllers.SongController;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is responsible for recommending a song to a user.
 */
public class RecommendSongToUser implements Commands {
    public RecommendSongToUser () {

    }

    /**
     * This method will prompt user to recommend song to another user.
     * @param state is the current state of the program.
     * @return whether the user has succeeded. Or return further instructions if the user did not succeed.
     * @throws IOException if the user did not login.
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        //Todo currently we haven't dealt with the case where the username user input is invalid.
        // we can do this in song manager possibly.
        // we also need to add a line tof code that always checks notification when user first logs in
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                RecommendController recommendController = state.getRecommendController();
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the song name you wish to share: ");
                String songname = sc.nextLine();
                System.out.println("Enter the person's username you wish to share the song to: ");
                String username = sc.nextLine();
                return recommendController.recommendSong(songname, username, state.getUserProfile().getUsername());
            } else {
                return "please Login first.";
            }
        } catch (Exception e) {
            return "please Login first.";
        }
    }
}
