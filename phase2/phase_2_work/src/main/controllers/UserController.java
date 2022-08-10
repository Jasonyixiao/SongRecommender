package controllers;

import usecases.UserManager;

import java.io.IOException;
import java.util.List;

/**
 * This Class is responsible for calling methods necessary for performing user-related tasks.
 */
public class UserController {
    private final UserManager userManager;

    /**
     * Constructor of the UserController, stores userManager .
     * @param userManager is responsible for performing account administrative tasks.
     */
    public UserController(UserManager userManager) {
        this.userManager =  userManager;
    }


    /**
     * This method will let a admin user to promote a normal user to admin user.
     * @param myUsername is the username of the user performing this task.
     * @param otherUsername is the username of the user being promoted.
     * @return a message informing user whether the task is performed successfully.
     */
    public String createAdminUser(String myUsername, String otherUsername) {
        return this.userManager.createAdmin(myUsername,otherUsername);
        // this is used in promte
    }

    /**
     * This method will create a normal user to the system.
     * @param username is the username of the new user.
     * @param password is the password of the new user.
     * @return messages and further instructions about the outcome of the operation.
     */
    public String createNormalUser(String username, String password) {
        if (!userManager.hasUser(username)) {
            this.userManager.createUser(username, password);
            return "User Created, Please Login.";
        } else {
            return "Username already Exist, Try Again!";
        }
        // first person created will be admin
    }

    /**
     * This method will let admin user delete a normal user.
     * @param myUsername is the username of the user performing this task.
     * @param otherUsername is the username of the user being deleted.
     * @return messages about the outcome of task.
     */
    public String deleteUser(String myUsername, String otherUsername) {
        if (!myUsername.equals(otherUsername)) {
            if (userManager.hasUser(otherUsername)) {
                return this.userManager.deleteUser(myUsername, otherUsername);
            } else {
                return "User Does Not Exist.";
            }
        } else {
            return "You Cannot Delete Yourself.";
        }
        // if admin tries to delete non-user successfully "command successful" is printed
        // if a non-admin tries to delete user, "you are not an admin" will be returned
        // if an admin tries to delete an admin, "You cannot delete admin." will be returned
    }
    /**
     * This method will let admin user ban a normal user.
     * @param myUsername is the username of the user performing this task.
     * @param otherUsername is the username of the user being banned.
     * @return messages about the outcome of task.
     */
    public String banUser(String myUsername, String otherUsername) {
        if (!myUsername.equals(otherUsername)) {
            return this.userManager.banUser(myUsername, otherUsername);
        } else {
            return "You Cannot Ban Yourself.";
        }
        // if admin tries to ban non-user successfully "command successful" is printed
        // if a non-admin tries to ban user, "you are not an admin" will be returned
        // if an admin tries to ban an admin, "You cannot ban admin." will be returned
    }

    /**
     * This method will get the login History of the user specified by username.
     * @param username is the username of the user checking their login history.
     * @return a list of login dates of the history.
     */
    public List<String> getLogInHistory(String username) {
        return this.userManager.getLoginHistory(username);
    }

    /**
     * This method will log out a user.
     * @param username is the username of the user logging out.
     */
    public void logOut(String username) {
        this.userManager.logout(username);
    }

    /**
     * This method will log in a user.
     * @param userContext is the object that contains the current user's information.
     * @param username  is the username of the user entered.
     * @param password is the password of the user entered.
     * @return true iff login is successful.
     */
    public boolean logIn(UserProfile userContext, String username, String password) {
        if (authenticate(userContext.getUsername(), userContext.getPassword()) != null) {
            return this.userManager.login(username, password);
        } else {
            return false;
        }
    }


    private UserProfile authenticate(String username, String password) {
        if (userManager.checkUsernamePasswordMatch(username, password)) {
            return new UserProfile(username, password);
        }
        else {
            return null;
        }
    }

    public void saveUserData() throws IOException {userManager.save();
    }
}
