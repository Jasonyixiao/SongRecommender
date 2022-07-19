package commands;

import controllers.ShellState;
import controllers.UserController;
import recommendStrategy.Recommender;
import recommendStrategy.recommendByAvgRating;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GetRecommend implements Commands{
    public GetRecommend(){

    }
    @Override
    public String executeCommand(ShellState state) throws IOException {
        try{
            if (state.getUserProfile().getIsSignedIn()){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the type of recommendation you want? (Currently we only have 'by rating')");
            String recommendType = scanner.nextLine();
            if (recommendType.equalsIgnoreCase("BY RATING")){
                Recommender ratingRecommender = new recommendByAvgRating();
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
