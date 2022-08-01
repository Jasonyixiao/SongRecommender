package controllers;

/**
 * This Class is responsible for calling the necessary methods for user to login or logout.
 */
public class LoginController {
    private final UserController userController;

    /**
     * This method will construct a LoginController, and stores a userController inside.
     * @param userController This Class is responsible for calling methods necessary for performing user-related tasks.
     */
    public  LoginController(UserController userController)
    {
        this.userController = userController;
    }

    /**
     * This method will log in a user.
     * @param username is the username of user.
     * @param password is the password of user.
     * @return the userprofile that contains user's contextual information for program future usage.
     */
    public UserProfile Login(String username, String password) {
        // call login from usercontroller
        UserProfile userContext = new UserProfile(username, password);
        if (userController.logIn(userContext, username, password)) {
            return userContext;
        } else {
            return null;
        }
    }

    /**
     * This method is a getter for UserController.
     * @return a userController.
     */
    public UserController getUserController() {
        return userController;
    }

    /**
     * This method will logout a user.
     * @param userContext contains the contextual information about the current use using the program.
     */
    public void LogOff(UserProfile userContext) {
        userController.logOut(userContext.getUsername());
        userContext.setIsSignedIn(false);
    }
}
