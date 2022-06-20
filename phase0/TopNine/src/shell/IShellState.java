package shell;

import controllers.ILoginController;
import controllers.IUserController;
import controllers.UserProfile;

public class IShellState {

    ILoginController loginController;
    IUserController userController;
    UserProfile userContext;

}
