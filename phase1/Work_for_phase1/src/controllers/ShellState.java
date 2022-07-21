package controllers;

import entities.Song;

/**
 *  This class is to check if the user is still active. The program will terminate once the user exit. This can be
 *  done by calling setIsRunning that sets isRunning to false, and while loop will terminate.
 */
public class ShellState {
    // this class is to check if the user is still active. The program will terminate once the user exit. This can be
    // done by calling setIsRunning that sets isRunning to false, and while loop will terminate.
    private boolean isRunning;
    private UserProfile userContext;

    private final LoginController loginController;

    private final SongController songController;

    /**
     * This method will construct a ShellState, saves loginController and songController. The default status for the
     * program is running.
     * @param loginController is responsible for calling the necessary methods for user to login or logout.
     * @param songController is responsible for calling the necessary methods for user to perform song-related tasks.
     */
    public ShellState (LoginController loginController, SongController songController) {
        this.isRunning = true;
        this.loginController = loginController;
        this.songController = songController;

    }

    /**
     * This methods will make the log in status of the user true.
     */
    public void setIsSignedIn(){
        this.userContext.setIsSignedIn(true);
    }


    /**
     * Getter for IsSignedIn.
     * @return the log in status of the user currently user the program.
     */
    public boolean getIsSignedIn() {
        return this.userContext.getIsSignedIn();
    }


    /**
     * Setters for UserProfile (Contains user contextual information)
     * @param userContext contains the user's contextual information (username, password, ...etc).
     */
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

    /**
     * Getter for UserProfile.
     * @return the UserProfile.
     */
    public UserProfile getUserProfile() {
        return userContext;
    }

    /**
     * This method will stop the program from running.
     */
    public void stopRunning() {
        this.isRunning = false;
    }

    /**
     * Getter for IsRunning.
     * @return whether the program is still running. (true for yes, false for no).
     */
    public boolean getIsRunning() {
        return this.isRunning;
    }

    /**
     * Getter for LoginController
     * @return the LoginController.
     */
    public LoginController getLoginController(){
        return this.loginController;
    }

    /**
     * Getter for SongController.
     * @return the SongController.
     */
    public SongController getSongController(){
        return this.songController;
    }
}
