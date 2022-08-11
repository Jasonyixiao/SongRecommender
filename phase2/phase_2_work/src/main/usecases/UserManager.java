package usecases;

import entities.User;

import java.io.IOException;
import java.util.*;

/**
 * This class is responsible for system users to do account administrative tasks.
 */
public class UserManager {
    private HashMap<String, User> allUsers;
    private final IGateWay gateWay;


    /**
     * Constructor for UserManager, stores an instance of IGateway, and initialize and stores allUsers.
     * @param g is the IGateway we use to store data.
     */
    public UserManager(IGateWay g) {
        this.allUsers = new HashMap<>(9999);
        this.gateWay = g;


    }


    /**
     * This method will create a User account in the system.
     * @param username is the new user's username.
     * @param password is the new user's password.
     */
    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        allUsers.put(newUser.getUsername(), newUser);
        if (User.totalPopulation == 1){           // for simplicity, first user registering will be admin
            newUser.setIsAdmin(1);
        }
    }

    /**
     * Getter for all users.
     * @return  HashMap<String, User> of all users.
     */
    public HashMap<String, User> getAllUsers(){
        return allUsers;
    }
    /**
     * This method will log a user into the system.
     * @param username is the username the user provide to authenticate.
     * @param password is the password the user provided to authenticate.
     * @return true iff the user has successfully logged in.
     */
    public boolean login(String username, String password) {
        User currentUser = allUsers.get(username);
        if (currentUser != null) {
            currentUser.appendLoginHistory();
            if (checkDateHelper(currentUser.getBanDate())) {
                return false; // If the code returns here then we know this user is banned
            }
            if (currentUser.getPassword().equals(password)) {
                currentUser.setIsSignedIn(true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * This method will check whether the user is being banned right now.
     * @param banUntilDate the date the user is banned until.
     * @return true iff the user is no longer banned.
     */
        private boolean checkDateHelper(Date banUntilDate){
        Date currentDay = new Date();
        return banUntilDate.after(currentDay);
    }


    /**
     * This method will log a user out of the system.
     * @param username is the username of the user logging out.
     */
    public void logout(String username) {
        User currentUser = allUsers.get(username);
        if (checkIsLogIn(username)) {
            currentUser.setIsSignedIn(false);
        }
    }


    /**
     * This method will check whether a user is logged in.
     * @param username is the username of the user being checked.
     * @return true iff the user is logged in.
     */
    private boolean checkIsLogIn(String username) {

        User currentUser = allUsers.get(username);
        if (currentUser != null) {
           return currentUser.getIsSignedIn();
        } else {
            return false;
        }
    }

    /**
     * Checks if a user is admin user.
     * @param username is the username of the user
     * @return true iff the user is admin
     */
    public boolean checkIsAdmin(String username){
        if(allUsers.get(username).getIsAdmin()==1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method will let admin users promote a normal user to admin user.
     * @param myUsername is the username of the user promoting other user.
     * @param otherUsername is the username of the user being promoted.
     * @return message regarding the outcome of the promoting.
     */
    public String createAdmin(String myUsername, String otherUsername){
        // user can only call this method when they are logged in
        // current admin has username myUsername
        // the person to be promoted has username otherUsername
        User currentUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (currentUser.getIsAdmin() == 1) {    // 1 means the current user is admin
            if (otherUser.getIsAdmin() == 0) {      // 0 mean the current user is normal user
                otherUser.setIsAdmin(1);
                return "Command successful.";

            }
            else{
                return "The user is already an admin.";
            }
        } else {
            return "You are not an admin.";
        }
    }


    /**
     * This method checks whether the system has the user specified by username.
     * @param username is the username of the user being checked.
     * @return true iff the system has this user.
     */
    public boolean hasUser(String username){
        User currentUser = allUsers.get(username);
        return currentUser != null;
    }


    /**
     * This method will let admin user delete a normal user.
     * @param myUsername is the username of the admin user deleting other user.
     * @param otherUsername is the username of the user being deleted.
     * @return message regarding the outcome of the deletion.
     */
    public String deleteUser(String myUsername, String otherUsername) {
        User currentUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (currentUser.getIsAdmin() == 1) {    // 1 means the current user is admin
            if (otherUser.getIsAdmin() == 0) {      // 0 mean the current user is normal user
                allUsers.remove(otherUsername);
                return "Command successful.";
            }
            else{
                return "You cannot delete admin.";
            }
        } else {
            return "You are not an admin.";
        }
    }


    /**
     * This method will get the logging history of the system user.
     * @param myUsername is username of the user checking their login history.
     * @return a list of string containing the logging history of the user.
     */
    public List<String> getLoginHistory(String myUsername) {
        // Users can only view history if they are logged in
        User currentUser = allUsers.get(myUsername);
        if (currentUser.getIsSignedIn()) {
            return new ArrayList<>(Arrays.asList(currentUser.getLoginHistory().split(",")));
        }
        else{
            return null;
        }
    }


    /**
     * This method will let an admin user ban another user.
     * @param myUsername is the username of the banning admin user.
     * @param otherUsername is the username of the user being banned.
     * @return message regarding the outcome of the banning activity.
     */
    public String banUser(String myUsername, String otherUsername) {
        User currentUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (currentUser.getIsAdmin() == 1) {    // 1 mean the current user is an admin
            if (otherUser.getIsAdmin() == 0){       // 0 means the current user is a noraml user
                otherUser.setBanDate(1);            // For simplicity, we will ban a user for 1 day.
                return "Command Successful!";
            }else{
                return "You cannot ban admin.";
            }
        } else {
            return "You are not an admin.";
        }
    }


    /**
     * This method checks whether the providing username and password matches the ones stored in the system.
     * @param username is the username provided.
     * @param password is the password provided.
     * @return true iff the username-password pair matches the ones in the system.
     */
    public boolean checkUsernamePasswordMatch (String username, String password) {
        User currentUser = allUsers.get(username);
        if (currentUser != null) {
            return currentUser.getPassword().equals(password);
        } else {
            return false;
        }
    }

    /**
     * This method returns the usernames of all the users in the system.
     * @return  the usernames of all the users in the system.
     */

    /**
     * This method will read the saved user data into the system and store it in allUsers.
     * @throws IOException if error reading from file.
     */
    public void read() throws ClassNotFoundException {

        allUsers = gateWay.readUser();
    }

    /**
     * This method will save Userdata into user file.
     * @throws IOException if error finding directory.
     */
    public void save() throws IOException {
        gateWay.save(allUsers, gateWay.getUserFile());


    }







}

