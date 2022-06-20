package controllers;

import java.io.IOException;
import java.util.List;

public interface IUserController {
    String createAdminUser(UserProfile userContext, String myUsername, String otherUsername);

    String createNormalUser(String username, String password);

    String logIn(String username, String password);

    String deleteUser(String myUsername, String otherUsername);

    String banUser(String myUsername, String otherUsername);

    List<String> getLogInHistory(String username);

    boolean logOut(String username) throws IOException;
}
