package commands;

import java.util.HashMap;

/**
 * This class is responsible for creating the required command based on user's input.
 */
public class CommandFactory {
    private HashMap<String, ICommands> commandMap;


    public CommandFactory() {
        commandMap = new HashMap<String, ICommands>();
        commandMap.put("REGISTER", new Register());
        commandMap.put("LOGIN", new Login());
        commandMap.put("LOGOUT", new Logout());
        commandMap.put("EXIT", new Exit()); ////////
        commandMap.put("CHECK HISTORY", new History()); // personal login
        commandMap.put("CREATE ADMIN USER", new CreateAdmin()); //Admin-admin/normal/self
        commandMap.put("DELETE USER", new Delete()); //admin-normal
        commandMap.put("BAN USER", new Ban());//admin- normal
        commandMap.put("RATE A SONG", new RateASong()); ////////
        commandMap.put("SEE RECOMMENDED SONGS", new GetRecommend()); /////
        commandMap.put("LISTEN", new Listen());
        commandMap.put("RECOMMEND TO USER", new RecommendSongToUser());  /////
        commandMap.put("CHECK NEW NOTIFICATIONS", new CheckNewNotification());
        commandMap.put("CHECK ALL NOTIFICATIONS", new CheckAllNotifications());


    }

    /**
     * This method will call the corresponding constructor of the different kinds of command objects.
     *
     * @param command is the user command
     * @return the corresponding kind of command.
     */
    public ICommands getCommand(String command) {
        if (command == null){
            return null;
        }else if (commandMap.containsKey(command.toUpperCase())){
            return commandMap.get(command.toUpperCase());


        }else{
            System.out.println ("A " + command.toLowerCase() + " is an undefined command for this program.");
            return null;
        }


    }
}

