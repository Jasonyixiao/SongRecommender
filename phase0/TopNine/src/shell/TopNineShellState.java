package shell;

import controllers.ILoginController;
import controllers.IUserController;
import controllers.UserProfile;

public class TopNineShellState implements ITopNineShellState{

    ILoginController loginController;
    IUserController userController;
    UserProfile userContext;

    public TopNineShellState()
    {
        isRunning = true;
    }
    private boolean isRunning;

    @Override
    public IUserController getUserController() {
        return userController;
    }

    @Override
    public ILoginController getLoginController() {
        return loginController;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
