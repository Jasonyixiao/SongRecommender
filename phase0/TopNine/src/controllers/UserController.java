package controllers;

import entities.User;
import usecases.UserManager;

import java.io.IOException;
import java.util.List;

public class UserController implements IUserController{
    private final UserManager userManager;

    public UserController() {
        this.userManager =  new UserManager(new GateWay());
    }

    private int usernameToId(String username){
        return userManager.idOfUser(username);
    }
    @Override
    public boolean createAdminUser(UserProfile userContext, String myUsername, String otherUsername) {
        // I assume userContext contain info about the current user that is trying to  create admin.
        if (authenticate(userContext.getUsername(), userContext.getPassword()) != null) {
            if(isAdmin(myUsername)) {
                return this.userManager.createAdmin(myUsername,otherUsername);
            } else return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean createNormalUser(UserProfile userContext, String username, String password) {
        this.userManager.createUser(username, password);
        return true;
    }



    public boolean logIn(UserProfile userContext, String username, String password) {
        return this.userManager.logIn(username, password);
    }

    @Override
    public boolean deleteUser(UserProfile userContext, String otherUsername) {
        if (authenticate(userContext.getUsername(), userContext.getPassword()) != null) {
            if(isAdmin(userContext.getUsername())) {
                return this.userManager.deleteUser(userContext.getUsername() ,otherUsername);
            } else return false;
        } else {
            return false;
        }
    }


    @Override
    public boolean banUser(UserProfile userContext, String otherUsername) {
        if (authenticate(userContext.getUsername(), userContext.getPassword()) != null) {
            if(isAdmin(userContext.getUsername())) {
                return this.userManager.banUser(userContext.getUsername(), otherUsername);
            } else return false;
        } else {
            return false;
        }
        // if admin tries to ban non-user successfully "command successful" is printed
        // if a non-admin tries to ban user, "you are not an admin" will be returned
        // if an admin tries to ban an admin, "You cannot ban admin." will be returned
    }
    @Override
    public List<String> getLogInHistory(UserProfile userContext) {
        // note that getLoginHistory already checks if the user is singed in.
        if (authenticate(userContext.getUsername(), userContext.getPassword()) != null) {
            return this.userManager.getLoginHistory(userContext.getUsername());
        } else {
            return null; // null is returned if the user cannot access the history
        }
    }

    @Override
    public UserProfile authenticate(String username, String password) {
        if (userManager.checkUsernamePasswordMatch(username, password)) {
            return new UserProfile(username, password);
        }
        else {
            return null;
        }
    }

    private boolean isAdmin(String username) {
        return userManager.checkIsAdmin(username); // 1 mean this user is an admin
    }
}
