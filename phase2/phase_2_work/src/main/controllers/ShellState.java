package controllers;

/**
 *  This class is to keep track of the current user's information.
 */
public class ShellState {


    private UserProfile userContext;

    private final LoginController loginController;

    private final SongController songController;

    private final NotificationController notificationController;

    /**
     * This method will construct a ShellState, saves loginController and songController. The default status for the
     * program is running.
     * @param loginController is responsible for calling the necessary methods for user to login or logout.
     * @param songController is responsible for calling the necessary methods for user to perform song-related tasks.
     */
    public ShellState (LoginController loginController, SongController songController, NotificationController
            notificationController) {

        this.loginController = loginController;
        this.songController = songController;
        this.notificationController = notificationController;

    }

    /**
     * Getter for notificationController
     * @return the notificaitonController
     */

    public NotificationController getNotificationController() {
        return notificationController;
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



    /**
     * Getter for UserProfile.
     * @return the UserProfile.
     */
    public UserProfile getUserProfile() {
        return userContext;
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
