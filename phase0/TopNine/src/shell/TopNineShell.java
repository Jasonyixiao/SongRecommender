package shell;
import shell.commands.CommandController;

import java.util.Scanner;

public class TopNineShell {
    public static void main(String[] args) {
        //LoginSystemState loginSystemState = new LoginSystemState();
        TopNineShellState topNineShellState = new TopNineShellState();
        CommandController commandExecutor = new CommandController();
        Scanner in = new Scanner(System.in);
        // keep reading the command and executing it until user exits the program
        while (topNineShellState.isRunning()) {
            System.out.print("$ ");
            // read next input line parse it and check if it is valid
            String commandLine = in.nextLine();
            try {
                String output = commandExecutor.executeCommand(topNineShellState, commandLine);
                if (!output.equals("")) {
                    System.out.println(output);
                }
            }
            catch (Exception e) {
                // TODO: change to CommandException everywhere.
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
