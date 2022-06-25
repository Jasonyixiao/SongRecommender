package controllers;

import usecases.UserManager;

import java.io.IOException;
import java.util.List;

public class UserController {
    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager =  userManager;
    }

    public String createAdminUser(String myUsername, String otherUsername) {
        return this.userManager.createAdmin(myUsername,otherUsername);
        // this is used in promte
    }

    public String createNormalUser(String username, String password) {
        this.userManager.createUser(username, password);
        return "New User created! Please Login. ";
        // first person created will be admin
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

    public boolean logOut(String username) throws IOException {
        return this.userManager.logout(username);
    }

    public boolean logIn(UserProfile userContext, String username, String password) {
        if (authenticate(userContext.getUsername(), userContext.getPassword()) != null) {
            return this.userManager.logIn(username, password);
        } else {
            return false;
        }
    }
    public UserProfile authenticate(String username, String password) {
        if (userManager.checkUsernamePasswordMatch(username, password)) {
            return new UserProfile(username, password);
        }
        else {
            return null;
        }
    }
}
