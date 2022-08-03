package commands;

import controllers.ShellState;
import controllers.SongController;

import java.util.Scanner;

public class ListenSong implements Commands{

    public ListenSong() {
    }

    public String executeCommand(ShellState state) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the song's name that you want to listen: "); // have to change the entity
        String songName = scanner.nextLine() ;

        SongController songController = state.getLoginController().getUserController(); // very disgusting
        return userController.createNormalUser();
    }
}