package shell.constants;

public class CommandException extends Exception {
    public CommandException(String msg) {
        super(msg);
    }

    public static final String TooManyArguments = "Too many arguments provided";
    public static final String NotEnoughArguments = "Not have enough arguments provided";
}
