package commands;

import controllers.ShellState;

import java.util.HashMap;

public class CommandController {
    //I want this class to store a map with all the Commands

    private HashMap<String, Commands> commands;
    public CommandController(ShellState state){
        this.commands = new HashMap<>();
        this.commands.put("000", new Register());
        this.commands.put("001", new Login());
        this.commands.put("002", new Logout());
        this.commands.put("003", new Exit());
        this.commands.put("004", new History());
        this.commands.put("005", new CreateAdmin());
        this.commands.put("006", new Delete());
    }

    public HashMap<String, Commands> getCommandMap() {
        return this.commands;
    }

}
