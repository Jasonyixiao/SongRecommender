package controllers;

import java.io.IOException;
import java.util.List;

public class userController implements IUserController{
    private final usecases.userManager userManager;

    public userController(usecases.userManager userManager) {
        this.userManager =  userManager;
    }

    private int usernameToId(String username){
        return userManager.idOfUser(username);
    }
    @Override
    public String createAdminUser(UserProfile userContext, String myUsername, String otherUsername) {

        //      Authenticate(userContext);
       //        IsAdmin(userContext);
                    return this.userManager.createAdmin(myUsername,otherUsername);
        // if admin created successfully "command successful" is printed
        // if a non-admin tries to create admin, "you are not an admin" will be returned
        // if an admin tries to create admin,
    }

    @Override
    public String createNormalUser(String username, String password) {
        this.userManager.createUser(username, password);
        return "Successful! ";
    }


    @Override
    public String logIn(String username, String password) {
        if(this.userManager.logIn(username, password)) {
            return "Successful.";
        } else {
            return "Incorrect username or password.";
        }
    }

    @Override
    public String deleteUser(String myUsername, String otherUsername) {
        return this.userManager.deleteUser(myUsername, otherUsername);
        // if admin tries to delete non-user successfully "command successful" is printed
        // if a non-admin tries to delete user, "you are not an admin" will be returned
        // if an admin tries to delete an admin, "You cannot delete admin." will be returned
    }

    @Override
    public String banUser(String myUsername, String otherUsername) {
        return this.userManager.banUser(myUsername, otherUsername);
        // if admin tries to ban non-user successfully "command successful" is printed
        // if a non-admin tries to ban user, "you are not an admin" will be returned
        // if an admin tries to ban an admin, "You cannot ban admin." will be returned
    }
    @Override
    public List<String> getLogInHistory(String username) {
        return this.userManager.getLoginHistory(username);
    }

    @Override
    public boolean logOut(String username) throws IOException {
        return this.userManager.logout(username);
    }

}
