package commands;

import controllers.ShellState;

import java.io.IOException;
import java.util.List;

public class GetRecommend implements Commands{
    public GetRecommend(){

    }
    @Override
    public String executeCommand(ShellState state) throws IOException {
        System.out.println(state.getSongController().getRecommend());
        return "here are the list of songs!";
    }
}
