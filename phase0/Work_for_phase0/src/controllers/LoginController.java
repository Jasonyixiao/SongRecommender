package controllers;
import usecases.AdminManager;

public interface LoginController {
    AdminManager Login(String username, String password);
    void LogOff(AdminManager userProfile);

}

