package shell.constants;

import java.util.Hashtable;


import shell.commands.*;
// TODO  Import commands from the Commands package

/**
 * This class holds the constants variables in the program
 */
public class Constants {


    // command dictionary
    public static final Hashtable<String, Command> COMMAND_DIC =
            new Hashtable<String, Command>();

    static {
        COMMAND_DIC.put("login", new Login());
        COMMAND_DIC.put("register", new Register());
        COMMAND_DIC.put("history", new History());
        COMMAND_DIC.put("logout", new Logout());
        COMMAND_DIC.put("exit", new Exit());
        COMMAND_DIC.put("user", new User());
        // TODO: All new commands should be placed under here
    }

    public static final Hashtable<String, String> COMMAND_DOCUMENTATION =
            new Hashtable<String, String>();

    static {
        COMMAND_DOCUMENTATION.put("Login","Login to the system");
        //TODO This is where to leave help or brief documentation for the user;
    }
}
