package controllers;

public class UserProfile {
        private final String username;
        //we're just going to keep this as a security token for now so the user as a sign in token
        private final String password;

        public UserProfile(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public String getUsername()
    {
        return username;
    }
}