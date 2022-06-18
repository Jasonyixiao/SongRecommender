package controllers;

import usecases.NormalUserManager;
import java.util.List;

public class NormalUserController implements NormalUserManagerInterface{
    @Override
    public void normalUserManager() {
        System.out.println("normalUserManager");
    }
    private NormalUserManager normalUserManager;
    //constructor
    public NormalUserController(NormalUserManager normalUserManager){
        this.normalUserManager = new NormalUserManager();
    }
    //method

    public boolean useLogin(String username, String password){
        return normalUserManager.login(username, password);
    }
    public void createNormalUserAccount(String username, String password){
        normalUserManager.createNormalUser(username, password);
    }

    public List<String> getUserLoginHistory (String username){
        return normalUserManager.getLoginHistory(username);
    }
}
