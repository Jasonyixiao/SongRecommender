package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private final String username;         // we need to enforce that usernames are UNIQUE

    private final String password;

    private int IsAdmin; // 1 is admin and 0 is admin

    private final List<String> loginHistory;

    private boolean isSignedIn;

    private final Calendar banUntil;

    private static int totalPopulation;

    public void setBanDate(){

        banUntil.setTime(new Date()); // Now use today date.

        banUntil.add(Calendar.DATE, 1); // Adds 15 days
    }

    public Date getBanDate() {
        return this.banUntil.getTime();
    }


    public User(String username, String password) {
        int id = totalPopulation;
        this.username = username; // this makes the usernames Unique
        this.password = password;
        this.IsAdmin = 0;
        this.isSignedIn = false;
        loginHistory = new ArrayList<>();
        banUntil = Calendar.getInstance();
        banUntil.setTime(new Date());
        totalPopulation++;
        if (id == 0) {
            IsAdmin = 1;
        }
    }
    public String getUsername(){
        return username;
    }


    public String getPassword(){
        return password;
    }


    public int getIsAdmin(){
        return IsAdmin;
    }

    public void setIsAdmin(int i){
        IsAdmin = i;
    }

    public void appendLoginHistory(){
        loginHistory.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
    }

    public List<String> getLoginHistory(){
        return loginHistory;
    }

    public boolean getIsSignedIn(){
        return isSignedIn;
    }

    public void setIsSignedIn(boolean b){
        this.isSignedIn = b;
    }




}
