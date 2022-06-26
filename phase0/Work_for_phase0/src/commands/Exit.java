package commands;

import controllers.ShellState;

public class Exit extends Commands{
    public Exit () {
    }

    @Override
    public String executeCommand(ShellState state) {
        state.stopRunning();
        Logout logout = new Logout();
        logout.executeCommand(state);
        return "Bye!";
    }
}
