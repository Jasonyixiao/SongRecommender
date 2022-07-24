package commands;

/**
 * This class is responsible for creating the required command based on user's input.
 */
public class CommandFactory {

    /**
     * This method will call the corresponding constructor of the different kinds of command objects.
     * @param command is the user command
     * @return the corresponding kind of command.
     */
    public Commands getCommand(String command) {

            if(command == null){
                return null;
            }

            if(command.equalsIgnoreCase("REGISTER")){
                return new Register();
            }

            else if(command.equalsIgnoreCase("LOGIN")){
                return new Login();
            }

            else if(command.equalsIgnoreCase("LOGOUT")){
                return new Logout();
            }

            else if(command.equalsIgnoreCase("EXIT")){
                return new Exit();
            }
            else if(command.equalsIgnoreCase("CHECK HISTORY")){
                return new History();
            }
            else if (command.equalsIgnoreCase("CREATE ADMIN USER")){
                return new CreateAdmin();
            }
            else if (command.equalsIgnoreCase("DELETE USER")){
                return new Delete();

            }
            else if (command.equalsIgnoreCase("BAN USER")){
                return new Ban();
            }
            else if (command.equalsIgnoreCase("RATE A SONG")){
                return new RateASong();
            }
            else if (command.equalsIgnoreCase("SEE RECOMMENDED SONGS")){
                return new GetRecommend();
            }
            else if (command.equalsIgnoreCase("LISTEN")){
                return new Listen();
            }
            else if (command.equalsIgnoreCase("RECOMMEND TO USER")) {
                return new RecommendSongToUser();
            }
            else if (command.equalsIgnoreCase("CHECK NEW NOTIFICATIONS")) {
                return new CheckNewNotification();
            }
            else if (command.equalsIgnoreCase("CHECK ALL NOTIFICATIONS")) {
                return new CheckAllNotifications();
            }
            else
            {
                System.out.println ("A " + command.toLowerCase() + " is an undefined command for this program.");
                return null;
            }
        }
    }

