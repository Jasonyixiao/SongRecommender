package shell;

import controllers.*;

public class ShellState implements IShellState {

    ILoginController loginController;
    IUserController userController;
    UserProfile userProfile;

    public ShellState()
    {
        isRunning = true;

        userController = new UserController();
        loginController = new LoginController(userController);
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

    @Override
    public UserProfile getUserProfile() {
        return userProfile;
    }

    @Override
    public void StopRunning() {
        isRunning = false;
    }
}
