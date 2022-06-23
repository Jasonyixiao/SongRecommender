package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private final int id;
    private String username;         // we need to enforce that usernames are UNIQUE

    private String password;

    private boolean isAdmin; // 1 is admin and 0 is not admin

    private final List<LocalDateTime> loginHistory;

    private LocalDateTime banUntil;

    private static int totalPopulation = 0;

    public void setBanDate(){

        banUntil = LocalDateTime.now().plusDays(15);
    }

    public LocalDateTime getBanDate() {
        return banUntil;
    }

    public int getId(){
        return id;
    }
    public User(String username, String password) {
        this.id = totalPopulation++;
        this.username = username;
        this.password = password;
        this.isAdmin = false;
        loginHistory = new ArrayList<>();
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean isAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(){
        isAdmin = true;
    }

    public void appendLoginHistory(){
        loginHistory.add(LocalDateTime.now());
    }

    public List<LocalDateTime> getLoginHistory(){
        return loginHistory;
    }
}
