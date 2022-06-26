package commands;

import controllers.ShellState;

import java.io.IOException;

public class Exit extends Commands{
    public Exit () {
    }

    @Override
    public String executeCommand(ShellState state) throws IOException {
        state.stopRunning();
        try {
            Logout logout = new Logout();
            logout.executeCommand(state);
        } catch (Exception e) {
            return "Bye!";
        }
        return "Bye!";
    }
}
