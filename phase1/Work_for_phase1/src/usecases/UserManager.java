package usecases;

import entities.User;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserManager {
    private HashMap<String, User> allUsers;
    private final IGateWay gateWay;

    public UserManager(IGateWay g) {
        this.allUsers = new HashMap<>(9999);
        this.gateWay = g;

    }

    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        allUsers.put(newUser.getUsername(), newUser);
    }

    public boolean logIn(String username, String password) {
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
        private boolean checkDateHelper(Date banUntilDate){
        Date currentDay = new Date();
        return banUntilDate.after(currentDay);
    }

    public void logout(String username) {
        User currentUser = allUsers.get(username);
        if (checkIsLogIn(username)) {
            currentUser.setIsSignedIn(false);
            try{
                gateWay.save(allUsers, gateWay.getUserFile());
            }catch (IOException e){
                e.printStackTrace();
            }
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

    public boolean checkUsernamePasswordMatch (String username, String password) {
        User currentUser = allUsers.get(username);
        if (currentUser != null) {
            return currentUser.getPassword().equals(password);
        } else {
            return false;
        }
    }


    public void read(){
        try {
            allUsers = gateWay.read_user();
        }catch (ClassNotFoundException ignored){
        }
    }

//    spublic void save(){
//        try {
//            gateWay.save(allUsers);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }





}

