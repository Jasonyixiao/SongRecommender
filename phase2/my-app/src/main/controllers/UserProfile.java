package controllers;

/**
 * This class will keep track of the user information when the user is using the program so we don't have
 * to repeated asks user about their username,password.. etc
 */
public class UserProfile {
    private final String username;
    //we're just going to keep this as a security token for now so the user as a sign in token
    private final String password;

    private boolean isSignedIn;

    /**
     * Constructor for UserProfile. Stores username, password and login status, default login status is true.
     * @param username is the username of the user.
     * @param password is the password of the user.
     */

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
        this.isSignedIn = true;
    }

    /**
     * Getter for IsSignedIn.
     * @return true iff the user is signed in.
     */
    public boolean getIsSignedIn() {
        return this.isSignedIn;
    }

    /**
     * Setter for IsSignedIn
     * @param input is the new log in status being set.
     */
    public void setIsSignedIn(boolean input) {
        this.isSignedIn = input;
    }

    /**
     * Getter for username.
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for password.
     * @return the password of the user.
     */
    public String getPassword() {
        return this.password;
    }

}