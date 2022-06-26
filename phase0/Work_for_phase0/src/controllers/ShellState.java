package controllers;

public class ShellState {
    // this class is to check if the user is still active. The program will terminate once the user exit. This can be
    // done by calling setIsRunning that sets isRunning to false, and while loop will terminate.
    private boolean isRunning;
    private UserProfile userContext;

    private LoginController loginController;

    public ShellState (LoginController loginController) {
        this.isRunning = true;
        this.loginController = loginController;
    }

    public void setIsSignedIn(){
        this.userContext.setIsSignedIn(true);
    }

    public void setLoggedOff() {
        this.userContext.setIsSignedIn(false);
    }

    public boolean getIsSignedIn() {
        return this.userContext.getIsSignedIn();
    }

    public void setUserProfile(UserProfile userContext) {
        if (userContext != null) {
            this.userContext = userContext;
        }
    }

    public UserProfile getUserProfile() {
        return userContext;
    }

    public void stopRunning() {
        this.isRunning = false;
    }

    public boolean getIsRunning() {
        return this.isRunning;
    }

    public LoginController getLoginController(){
        return this.loginController;
    }
}
