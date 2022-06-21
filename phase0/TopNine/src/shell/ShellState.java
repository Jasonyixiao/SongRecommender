package shell;

import controllers.ILoginController;
import controllers.IUserController;
import controllers.UserProfile;

public class ShellState implements IShellState {

    ILoginController loginController;
    IUserController userController;
    UserProfile userProfile;

    public ShellState()
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

    @Override
    public void setUserProfile(UserProfile loginUser) {
        this.userProfile = loginUser;
    }
}
