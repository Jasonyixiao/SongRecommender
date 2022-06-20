package controllers;

import java.io.IOException;
import java.util.List;

public interface IUserController {
    boolean createAdminUser(UserProfile userContext, String myUsername, String otherUsername);

    boolean createNormalUser(UserProfile userContext, String username, String password);

    UserProfile authenticate(String username, String password);

    boolean deleteUser(UserProfile userContext, String username);

    boolean banUser(UserProfile userContext, String otherUsername);

    List<String> getLogInHistory(UserProfile userContext);

    boolean logOut(String username) throws IOException;
}
