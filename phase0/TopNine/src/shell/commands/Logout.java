package shell.commands;

import shell.IShellState;

import java.util.List;

public class Logout extends Command {

    public Logout()
    {
        super(0,0);
    }
    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {
        shellState.setUserProfile(null);
        return "User logged out.";
    }
}
