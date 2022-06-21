package shell;


import controllers.ILoginController;
import controllers.IUserController;
import controllers.UserProfile;

public interface IShellState {

    IUserController getUserController();
    ILoginController getLoginController();

    boolean isRunning();

    void setUserProfile(UserProfile loginUser);

    UserProfile getUserProfile();

    void StopRunning();
}
