package controllers;

public class LoginController implements ILoginController {
    private UserController userController;

    public  LoginController(UserController userController)
    {
        this.userController = userController;
    }

    @Override
    public UserProfile Login(String username, String password) {
        // call login from usercontroller
        UserProfile userContext = new UserProfile(username, password);
        if (userController.logIn(userContext, username, password)) {
            return userContext;
        } else {
            return null;
        }
    }

    public UserController getUserController() {
        return userController;
    }

    @Override
    public void LogOff(UserProfile userContext) {
        //....
    }
}
