package shell.constants;

import java.util.Hashtable;
import shell.commands.Command;
// TODO  Import commands from the Commands package

/**
 * This class holds the constants variables in the program
 */
public class Constants {


    // command dictionary
    public static final Hashtable<String, Command> COMMAND_DIC =
            new Hashtable<String, Command>();

    static {
      /*  COMMAND_DIC.put("Login", new Login());
        COMMAND_DIC.put("Register", new Register());
        COMMAND_DIC.put("History", new History());
        COMMAND_DIC.put("Logout", new Exit());
        COMMAND_DIC.put("Exit", new Exit());*/
        // TODO: All new commands should be placed under here
    }

    public static final Hashtable<String, String> COMMAND_DOCUMENTATION =
            new Hashtable<String, String>();

    static {
        COMMAND_DOCUMENTATION.put("Login","Login to the system");
        //TODO This is where to leave help or brief documentation for the user;
    }
}
