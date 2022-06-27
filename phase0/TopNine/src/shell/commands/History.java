package shell.commands;

import shell.IShellState;

import java.time.LocalDateTime;
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
        List<LocalDateTime> loginHistory = userController.getLogInHistory(shellState.getUserProfile());

        sb.append(shellState.getUserProfile().getUsername() + "'s login history:\n");
        for (LocalDateTime history : loginHistory) {
            sb.append(history + "\n");
        }
        return sb.toString();
    }
}
