package commands;

import controllers.ShellState;

import java.io.IOException;

public class Exit implements Commands{
    public Exit () {
    }

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
