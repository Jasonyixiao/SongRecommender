package usecases;

import entities.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserManager {
    private HashMap<String, User> allUsers;
    private final IGateWay gateWay;

    public UserManager(IGateWay g) {
        this.allUsers = new HashMap<String, User>(9999);
        this.gateWay = g;
    }
    public HashMap<String, User> getAllUsers(){
        return allUsers;
    }
    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        allUsers.put(username, newUser);
    }

    public boolean logIn(String username, String password) {
        User currentUser = allUsers.get(username);
        if (currentUser != null) {
            return currentUser.getPassword().equals(password);
        } else {
            return false;
        }
    }

    public boolean logout(String username) throws IOException {
        User currentUser = allUsers.get(username);
        if (checkIsLogIn(username)) {
            currentUser.setIsSignedIn(false);
            try{
                gateWay.save(allUsers);
                return true;
            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean checkIsLogIn(String username) {

        User currentUser = allUsers.get(username);
        if (currentUser != null) {
           return currentUser.getIsSignedIn();
        } else {
            return false;
        }
    }

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

    public boolean hasUser(String username){
        User currentUser = allUsers.get(username);
        return currentUser != null;
    }

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

    public List<String> getLoginHistory(String myUsername) {
        // Users can only view history if they are logged in
        User currentUser = allUsers.get(myUsername);
        if (currentUser.getIsSignedIn()) {
            return currentUser.getLoginHistory();
        }
        else{
            return null;
        }
    }

    public String banUser(String myUsername, String otherUsername) {
        User currentUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (currentUser.getIsAdmin() == 1) {    // 1 mean the current user is an admin
            if (otherUser.getIsAdmin() == 0){       // 0 means the current user is a noraml user
                otherUser.setBanDate();
                return "Command Successful!";
            }else{
                return "You cannot ban admin.";
            }
        } else {
            return "You are not an admin.";
        }
    }

    public void read(){
        try {
            allUsers = gateWay.read();
        }catch (ClassNotFoundException ignored){
        }
    }

    public void save(){
        try {
            gateWay.save(allUsers);
        }catch (IOException e){
            e.printStackTrace();
        }
    }





}

