package shell.commands;

import shell.IShellState;

import java.util.List;

public class Exit extends Command {

    public Exit()
    {
        super(0,0);
    }
    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {
        shellState.StopRunning();
        return "Byte!";
    }
}
