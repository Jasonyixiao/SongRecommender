package shell.commands;

import java.util.List;

import shell.constants.CommandException;
import shell.IShellState;


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
            (IShellState shellState, List<String> arguments) throws Exception;

    // Checks to see if there are the correct number of arguments.
    // Throws if there are too many or not enough arguments
    protected void checkArgumentsNum(List<String> arguments) throws Exception {
        if (arguments.size() > maxArguments) {

            throw new CommandException(CommandException.TooManyArguments);
        }
        if (arguments.size() < minArguments) {
            throw new CommandException(CommandException.NotEnoughArguments);
        }
    }

}
