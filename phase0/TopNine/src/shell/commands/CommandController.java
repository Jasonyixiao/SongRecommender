package shell.commands;

import java.util.List;
import shell.ITopNineShellState;
import shell.constants.CommandException;
import shell.constants.Constants;
import shell.constants.Exceptions;

/**
 * Decorates and executes command appropriately based on arguments provided
 */
public class CommandController {

    /**
     * Executes the provided command line
     *
     * @param shellState  is the state of the program
     * @param commandLine is the given command line and arguments
     * @return string that is given back as command is executed
     * @throws Exception if any of the provided arguments is invalid
     */
    public String executeCommand(ITopNineShellState shellState, String commandLine)
            throws Exception {
        // TODO: clean this up.
        if (commandLine.equals("")) {
            return "";
        }
        // use command reader to separate command with arguments
        CmdArgTuple cmdArgTuple = CommandReader.parseCommandLine(commandLine);
        Command command = getCommand(cmdArgTuple);
        List<String> arguments = cmdArgTuple.getArguments();


        String result = command.executeCommand(shellState, arguments);
        // if command doesn't result in an error add it to STD OUTPUT history
        return result;
    }

    private Command getCommand(CmdArgTuple cmdArgTuple) throws CommandException {
        String command = cmdArgTuple.getCommand();
        if (!CommandReader.isValidCommand(command)) {
            throw new CommandException(Exceptions.COMMAND_NOT_FOUND);
        }
        return Constants.COMMAND_DIC.get(command);
    }
}