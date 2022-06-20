package controllers;

public interface ILoginController {

    UserProfile Login(String userName, String password);
    void LogOff(UserProfile userProfile);

}
