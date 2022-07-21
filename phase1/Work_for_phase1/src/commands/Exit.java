package commands;

import controllers.ShellState;

import java.io.IOException;

/**
 * This class is responsible for exiting the program
 */
public class Exit implements Commands{
    public Exit () {
    }

    /**
     * This method will let user exit the program.
     * @param state
     * @return a goodbye message to the user.
     * @throws IOException if the user has already logged out.
     */
    @Override
    public String executeCommand(ShellState state) throws IOException {
        state.stopRunning();
        state.getSongController().saveData();
        try {
            Logout logout = new Logout();
            logout.executeCommand(state);
        } catch (Exception e) {
            return "Bye!";
        }
        return "Bye!";
    }
}
