package commands;

import controllers.NotificationController;
import controllers.ShellState;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is responsible for recommending a song to a user.
 */
public class RecommendSongToUser implements ICommands {
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
        try {
            if (state.getUserProfile().getIsSignedIn()) {
                NotificationController notificationController = state.getNotificationController();
                String sender = state.getUserProfile().getUsername();
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the song name you wish to share: ");
                String songname = sc.nextLine();
                System.out.println("Enter the person's username you wish to share the song to: ");
                String receiver = sc.nextLine();
                System.out.println("Add a message: ");
                String message = sc.nextLine();
                System.out.println("Add url: ");
                String content = sc.nextLine();
//                String result = notificationController.recommendSong(songname,receiver,sender,message);

//                return result;
            } else {
                return "please Login first.";
            }
        } catch (Exception e) {
            return "please Login first.";
        }
        return null;
    }
}
