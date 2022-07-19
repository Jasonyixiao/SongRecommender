package controllers;

import entities.Song;

public class ShellState {
    // this class is to check if the user is still active. The program will terminate once the user exit. This can be
    // done by calling setIsRunning that sets isRunning to false, and while loop will terminate.
    private boolean isRunning;
    private UserProfile userContext;

    private final LoginController loginController;

    private final SongController songController;


    public ShellState (LoginController loginController, SongController songController) {
        this.isRunning = true;
        this.loginController = loginController;
        this.songController = songController;

    }

    public void setIsSignedIn(){
        this.userContext.setIsSignedIn(true);
    }


    public boolean getIsSignedIn() {
        return this.userContext.getIsSignedIn();
    }

    public void setUserProfile(UserProfile userContext) {
        if (userContext != null) {
            this.userContext = userContext;
        }
    }

//    public void setSongProfile(SongController songController) {
//        if (songController != null) {
//            this.songController = songController;
//        }
//    }

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
    public SongController getSongController(){
        return this.songController;
    }
}
