package controllers;

import controllers.ILoginController;
import controllers.IUserController;
import controllers.UserProfile;

public class LoginController implements ILoginController {
    IUserController userController;

    public  LoginController(IUserController userController)
    {
        this.userController = userController;
    }

    @Override
    public UserProfile Login(String username, String password) {
        //.....
        return new UserProfile(username, password);
    }

    @Override
    public void LogOff(UserProfile userProfile) {
        //....
    }
}
