package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private String username;         // we need to enforce that usernames are UNIQUE

    private String password;

    private int IsAdmin; // 1 is admin and 0 is admin

    private List<String> loginHistory;

    private boolean isSignedIn;

    private Calendar banUntil;

    private int id;

    private static int totalPopulation;

    public void setBanDate(){

        banUntil.setTime(new Date()); // Now use today date.

        banUntil.add(Calendar.DATE, 1); // Adds 15 days
    }

    public Date getBanDate() {
        return this.banUntil.getTime();
    }


    public User(String username, String password) {
        this.id = totalPopulation;
        this.username = username + id; // this makes the usernames Unique
        this.password = password;
        this.IsAdmin = 0;
        this.isSignedIn = false;
        loginHistory = new ArrayList<String>();
        banUntil = Calendar.getInstance();
        banUntil.setTime(new Date());
        totalPopulation++;
        if (this.id == 0) {
            IsAdmin = 1;
        }
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
