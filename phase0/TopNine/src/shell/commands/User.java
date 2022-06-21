package shell.commands;

import shell.IShellState;

import java.util.List;

public class User extends Command{

    public User()
    {
        super(2, 2);
    }
    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {
        return null;
    }
}
