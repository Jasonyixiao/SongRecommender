package commands;

import controllers.ShellState;

import java.io.IOException;

public interface Commands {

    public abstract String executeCommand(ShellState state) throws IOException;

}