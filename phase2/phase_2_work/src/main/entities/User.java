package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This Class represent a user in our system.
 */
public class User implements Serializable {

    private final String username;         // we need to enforce that usernames are UNIQUE

    private final String password;

    private int IsAdmin; // 1 is admin and 0 is admin

    private final List<String> loginHistory;

    private boolean isSignedIn;

    private final Calendar banUntil;

    public static int totalPopulation;

    /**
     * Constructor of the user. stores its username and password.
     * @param username is the username of the user.
     * @param password is the password of the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.IsAdmin = 0;
        this.isSignedIn = false;
        loginHistory = new ArrayList<>();
        banUntil = Calendar.getInstance();
        banUntil.setTime(new Date());
        totalPopulation++;

    }

    /**
     * Sets the ban-until date of this user.
     */
    public void setBanDate(int i ){
        banUntil.setTime(new Date());
        banUntil.add(Calendar.DATE, i); // Adds i day
    }

    /**
     * Getter for the Ban until Date
     * @return a date of which this user is banned util.
     */
    public Date getBanDate() {
        return this.banUntil.getTime();
    }


    /**
     * Getter for username.
     * @return this user's username.
     */
    public String getUsername(){
        return username;
    }

    /**
     * Getter for password.
     * @return this user's password.
     */
    public String getPassword(){
        return password;
    }

    /**
     * Getter for IsAdmin
     * @return 1 if user is admin , return 0 if user is non-admin.
     */
    public int getIsAdmin(){
        return IsAdmin;
    }

    /**
     * Setter of IsAdmin
     * @param i is the value the user sets IsAdmin to.
     */
    public void setIsAdmin(int i){
        IsAdmin = i;
    }

    /**
     * Adds the current time to the login history.
     */
    public void appendLoginHistory(){
        loginHistory.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
    }

    /**
     * Getter for login history.
     * @return a list of login times.
     */
    public List<String> getLoginHistory(){
        return loginHistory;
    }

    /**
     * Getter for IsSignedIn.
     * @return true iff this user is signed in.
     */
    public boolean getIsSignedIn(){
        return isSignedIn;
    }

    /**
     * Setter of isSignedIn
     * @param b the value we want to set isSignIn to.
     */
    public void setIsSignedIn(boolean b){
        this.isSignedIn = b;
    }




}
