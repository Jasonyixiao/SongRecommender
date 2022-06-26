package commands;

import controllers.ShellState;

import java.io.IOException;

public abstract class Commands {

    public abstract String executeCommand(ShellState state) throws IOException;

}
