package commands;

import controllers.ShellState;

import java.io.IOException;

public class Exit extends Commands{
    public Exit () {
    }

    @Override
    public String executeCommand(ShellState state) throws IOException {
        state.stopRunning();
        Logout logout = new Logout();
        logout.executeCommand(state);
        return "Bye!";
    }
}
