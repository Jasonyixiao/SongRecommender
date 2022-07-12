package commands;

import controllers.ShellState;

import java.io.IOException;

public interface Commands {

    String executeCommand(ShellState state) throws IOException;

}