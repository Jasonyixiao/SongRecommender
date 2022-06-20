package controllers;

public class UserProfile {
    private int userId;
    private String username;
    private String password;

    public UserProfile(int userId, String username, String password)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
}
