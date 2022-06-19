package controllers;

import usecases.UserManager;
import java.util.List;

public class UserController {
    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager =  userManager;
    }

    public String createAdminUser(String myUsername, String otherUsername) {
        return this.userManager.createAdmin(myUsername,otherUsername);
        // if admin created successfully "command successful" is printed
        // if a non-admin tries to create admin, "you are not an admin" will be returned
        // if an admin tries to create admin,
    }


    public String logIn(String username, String password) {
        if(this.userManager.logIn(username, password)) {
            return "Successful.";
        } else {
            return "Incorrect username or password.";
        }
    }

    public String deleteUser(String myUsername, String otherUsername) {
        return this.userManager.deleteUser(myUsername, otherUsername);
        // if admin tries to delete non-user successfully "command successful" is printed
        // if a non-admin tries to delete user, "you are not an admin" will be returned
        // if an admin tries to delete an admin, "You cannot delete admin." will be returned
    }

    public String banUser(String myUsername, String otherUsername) {
        return this.userManager.banUser(myUsername, otherUsername);
        // if admin tries to ban non-user successfully "command successful" is printed
        // if a non-admin tries to ban user, "you are not an admin" will be returned
        // if an admin tries to ban an admin, "You cannot ban admin." will be returned
    }
    public List<String> getLogInHistory(String username) {
        return this.userManager.getLoginHistory(username);
    }

}
