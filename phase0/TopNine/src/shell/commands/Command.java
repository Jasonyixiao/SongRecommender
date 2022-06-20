package shell.commands;

import java.util.List;

import shell.constants.CommandException;
import shell.ITopNineShellState;

/**
 * This is a base class for any commands that might be needed in the program
 */
public abstract class Command {
    protected final int maxArguments;
    protected final int minArguments;

    public Command(int maxArguments, int minArguments) {
        this.maxArguments = maxArguments;
        this.minArguments = minArguments;
    }

    public int getMaxArg() {
        return maxArguments;
    }

    public int getMinArg() {
        return minArguments;
    }

    abstract public String executeCommand
            (ITopNineShellState loginSystemState, List<String> arguments) throws Exception;

    // TODO: write Javadoc
    protected void checkArgumentsNum(List<String> arguments) throws Exception {
        if (arguments.size() > maxArguments) {
            // TODO: add this message to class constants.Exceptions
            throw new CommandException("too many arguments provided");
        }
        if (arguments.size() < minArguments) {
            throw new CommandException("too little arguments provided");
        }
    }

}
