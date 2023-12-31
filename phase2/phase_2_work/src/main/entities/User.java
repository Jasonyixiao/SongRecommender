package entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This Class represent a user in our system.
 */
public class User implements Serializable {

    private final String username;         // we need to enforce that usernames are UNIQUE

    private final String password;

    private int IsAdmin; // 1 is admin and 0 is admin

    private String loginHistory;

    private boolean isSignedIn;
    private final String banUntil;

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
        loginHistory = "";
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        banUntil = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date.getTime());
        totalPopulation++;

    }

    /**
     * Sets the ban-until date of this user.
     */
    public void setBanDate(int i ){
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.add(Calendar.DATE, i); // Adds i day
        String banUntil = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date.getTime());
    }

    /**
     * Getter for the Ban until Date
     * @return a date of which this user is banned util.
     */
    public Date getBanDate() {
        try {
            return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse(this.banUntil);
        } catch (ParseException e) {
            return new Date();
        }
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
        if (loginHistory.length() == 0) {
             loginHistory = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        } else {
            loginHistory = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + ", " + loginHistory;
        }
    }

    /**
     * Getter for login history.
     * @return a list of login times.
     */
    public String getLoginHistory(){
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
