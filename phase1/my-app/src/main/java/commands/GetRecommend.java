package commands;

import controllers.ShellState;
import recommendStrategy.IRecommender;
import recommendStrategy.recommendByAvgRating;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is responsible for generate recommended songs.
 */
public class GetRecommend implements ICommands {
    public GetRecommend(){

    }

    /**
     * This method will provide recommended songs for the user.
     * @param state is the current state of the program
     * @return whether the user has succeeded. Or return further instructions if the user did not succeed.
     * @throws IOException if the user didn't log in.
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        try{
            if (state.getUserProfile().getIsSignedIn()){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the type of recommendation you want? (Currently we only have 'by rating')");
            String recommendType = scanner.nextLine();
            if (recommendType.equalsIgnoreCase("BY RATING")){
                IRecommender ratingRecommender = new recommendByAvgRating();
                System.out.println(state.getSongController().getRecommend(ratingRecommender));
                return "here are the list of songs!";
            }
            else {
                System.out.println ("A " + recommendType.toLowerCase() + " is an invalid recommend type for this program.");
                return null;

            }
        }else {
            return "Please Login First.";
        }
        } catch (Exception e){
            return "Please Login First.";
        }



    }
}
