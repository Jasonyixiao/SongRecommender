package commands;

import controllers.ShellState;

import java.io.IOException;

/**
 * Interface for commands that can be executed.
 */
public interface Commands {

    String executeCommand(ShellState state) throws IOException;

}