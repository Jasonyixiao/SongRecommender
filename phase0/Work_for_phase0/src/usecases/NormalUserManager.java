package usecases;

import entities.NormalUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NormalUserManager {
    private ArrayList<NormalUser> allNormalUsers;

    public NormalUserManager(){
        allNormalUsers = new ArrayList<NormalUser>();
    }
    public List<NormalUser> getAllNormalUsers(){
        return allNormalUsers;
    }

    public boolean login(String username, String password){
        for(NormalUser user: allNormalUsers){
            if (user.getUsername().equals(username)){
                if (checkDateHelper(user.getBanDate())) {
                    return false;
                }
                if (user.getPassword().equals(password)){
                    user.setIsSignedIn(true);
                    user.appendLoginHistory(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false; //no such user in the list
    }

    private boolean checkDateHelper(Date banUntilDate){
        Date currentDay = new Date();
        return banUntilDate.after(currentDay);
    }

    public void createNormalUser(String username, String password){
        NormalUser newNormalUser = new NormalUser(username, password);
        appendToList(newNormalUser);

    }

    public boolean checkInList(String username){
        for(entities.NormalUser user: allNormalUsers){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    private boolean checkLogIn(String username ){
        for(NormalUser user: allNormalUsers){
            if (user.getUsername().equals(username)){
                return user.getIsSignedIn();
            }
        }
        return false; //no such user in the list
    }

    public List<String> getLoginHistory (String username){
        //Assumes this user is in the list of allAdminUsers//
        for(NormalUser user: allNormalUsers){
            if (user.getUsername().equals(username)){
                return user.getLoginHistory();
            }
        }
        return null; //no such user in the list
    }

    public void appendToList(NormalUser user){
        allNormalUsers.add(user);
    }
    public void removeFromList(NormalUser user){
        allNormalUsers.remove(user);

    }


}
