package controllers;


public class UserProfile {
    private final String username;
    //we're just going to keep this as a security token for now so the user as a sign in token
    private final String password;

    private boolean isSignedIn;


    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
        this.isSignedIn = true;
    }

    public boolean getIsSignedIn() {
        return this.isSignedIn;
    }

    public void setIsSignedIn(boolean input) {
        this.isSignedIn = input;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return this.password;
    }

}