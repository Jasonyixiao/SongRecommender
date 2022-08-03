package controllers;

public class SongProfile {

    private final String songName;

    private final String songUrl;


    public SongProfile(String songName, String songUrl) {
        this.songName = songName;
        this.songUrl = songUrl;
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