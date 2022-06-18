package controllers;

import usecases.AdminManager;
import java.util.List;

@Controller
public class AdminController {
    private AdminManager adminManager;
    public AdminController(AdminManager adminManager) {
        this.adminManager = new AdminManager();
    }
    // AdminController stores an instance of AdminManage

    public List<AdminUser> getAllAdminUsers(){
        return adminManager.getAllAdminUsers();
    }

    public void createAdminUser(String username, String password) {
        adminManager.create_admin_user(username, password);
    }

    public boolean userLogin(String username, String password) {
        return adminManager.login(username, password);
    }

    public void appendToList(AdminUser user){
        adminManager.appendToList(user);
    }
    public void deleteUserAccount(String username, String password) {
        adminManager.deleteUser(username);
    }

    public List<String> getLoginHistoryList (String username){
        return adminManager.getLoginHistory(username);
    }

    public boolean banUserAccount(User someUser){
        return adminManager.banUser(someUser);
    }


}