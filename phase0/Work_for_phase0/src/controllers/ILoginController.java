package controllers;

import java.io.IOException;

public interface ILoginController {

    // Userprofile should be created here.
    UserProfile Login(String userName, String password);
    void LogOff(UserProfile userProfile) throws IOException;

}