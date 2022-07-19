package commands;

import controllers.ShellState;

import java.util.HashMap;

public class CommandController {
    //I want this class to store a map with all the Commands

    private final HashMap<String, Commands> commands;
    public CommandController(){
        this.commands = new HashMap<>();
        this.commands.put("000", new Register());
        this.commands.put("001", new Login());
        this.commands.put("002", new Logout());
        this.commands.put("003", new Exit());
        this.commands.put("004", new History());
        this.commands.put("005", new CreateAdmin());
        this.commands.put("006", new Delete());
        this.commands.put("007", new Ban());
        this.commands.put("008", new RateASong());
        this.commands.put("009", new GetRecommend());

        // this.commands.put("012", new );
        // this.commands.put("013", new );

    }

    public HashMap<String, Commands> getCommandMap() {
        return this.commands;
    }

}
