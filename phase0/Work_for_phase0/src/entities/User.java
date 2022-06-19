package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User {

    private String username;

    private String password;

    private int IsAdmin;

    private List<String> loginHistory;

    private boolean isSignedIn;

    private Calendar banUntil;

    private int id;

    private static int totalPopulation = 0;

    public void setBanDate(){

        banUntil.setTime(new Date()); // Now use today date.

        banUntil.add(Calendar.DATE, 1); // Adds 15 days
    }

    public Date getBanDate() {
        return this.banUntil.getTime();
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.IsAdmin = 0;
        this.isSignedIn = false;
        loginHistory = new ArrayList<String>();
        banUntil = Calendar.getInstance();
        banUntil.setTime(new Date());
        this.id = totalPopulation;
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

    public void appendLoginHistory(String d){
        loginHistory.add(d);
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

    public int getId(){
        return id;
    }


}
