package usecases;

import entities.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserManager {
    private HashMap<String, User> allUsers;
    private final IGateWay gateWay;

    public UserManager(IGateWay g) {
        this.allUsers = new HashMap<>();
        this.gateWay = g;
    }
    public HashMap<String, User> getAllUsers(){
        return allUsers;
    }

    public int idOfUser(String username){
        return allUsers.get(username).getId();
    }
    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        allUsers.put(username, newUser);
    }

    public boolean logIn(String username, String password) {
        User currentUser = allUsers.get(username);
        if (currentUser != null) {
            if (currentUser.getBanDate().isBefore(LocalDateTime.now())) {
                return false; // If the code returns here then we know this user is banned ????
            } else if (checkUsernamePasswordMatch(username, password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
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
    private boolean checkDateHelper(Date banUntilDate){
        Date currentDay = new Date();
        //LocalTime
        // LocalDateTime.now();
        return banUntilDate.after(currentDay);
    }


    public boolean createAdmin(String myUsername, String otherUsername){
        // user can only call this method when they are logged in
        // current admin has username myUsername
        // the person to be promoted has username otherUsername
        User myUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (myUser.isAdmin()) {    // 1 means the current user is admin
            if (!otherUser.isAdmin()) {      // 0 mean the other user is normal user
                otherUser.setIsAdmin();
                return true;
            }
            else{
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean checkIsAdmin(String username) {
        User currentUser = allUsers.get(username);
        return currentUser.isAdmin();
    }

    public boolean hasUser(String username){
        User currentUser = allUsers.get(username);
        return currentUser != null;
    }

    public boolean deleteUser(String myUsername, String otherUsername) {
        User currentUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (currentUser.isAdmin()) {    // 1 means the current user is admin
            if (!otherUser.isAdmin()) {      // 0 mean the current user is normal user
                allUsers.remove(otherUsername);
                return true;
            }
            else{
                return false;
            }
        } else {
            return false;
        }
    }

    public List<String> getLoginHistory(String myUsername) {
        // Users can only view history if they are logged in
        User currentUser = allUsers.get(myUsername);

        if(currentUser!= null)
        {
            return currentUser.getLoginHistory();
        }
        else
        {
            return new ArrayList<>();
        }

    }

    public boolean banUser(String myUsername, String otherUsername) {
        User currentUser = allUsers.get(myUsername);
        User otherUser = allUsers.get(otherUsername);
        if (currentUser.isAdmin()) {    // 1 mean the current user is an admin
            if (!otherUser.isAdmin()){       // 0 means the current user is a noraml user
                otherUser.setBanDate();
                return true;
            }else{
                return false;
            }
        } else {
            return false;
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

