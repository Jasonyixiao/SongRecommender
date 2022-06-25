package commands;

import controllers.ShellState;

public abstract class Commands {

    public abstract String executeCommand(ShellState state);

}
