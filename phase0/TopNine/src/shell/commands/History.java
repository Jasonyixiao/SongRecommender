package shell.commands;

import controllers.IUserController;
import shell.IShellState;

import java.util.List;

public class History extends Command {

    public History()
    {
        super(1,0);
    }
    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Exception {

        StringBuilder sb = new StringBuilder();
        IUserController userController = shellState.getUserController();
        List<String> loginHistory = userController.getLogInHistory(shellState.getUserProfile());

        sb.append(shellState.getUserProfile().getUsername() + "'s login history:\n");
        for (String history : loginHistory) {
            sb.append(history + "\n");
        }
        return sb.toString();
    }
}
