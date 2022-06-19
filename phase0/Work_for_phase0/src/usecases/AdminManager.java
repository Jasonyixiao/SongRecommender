package usecases;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminManager {
    private ArrayList<AdminUser> allAdminUsers;
    private NormalUserManager normalManager;


    public AdminManager() {
        allAdminUsers = new ArrayList<AdminUser>();
    }

    public void create_admin_user(String username, String password) {
        AdminUser new_admin_user = new AdminUser(username, password);
        appendToList(new_admin_user);
        // @Henry： 这里要在database里加新user的信息

    }

    public List<AdminUser> getAllAdminUsers() {

        return allAdminUsers;
    }

    public boolean checkInList(String username) {
        for (entities.AdminUser user : allAdminUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLogIn(String username) {

        for (AdminUser user : allAdminUsers) {
            if (user.getUsername().equals(username)) {
                return user.getIsSignedIn();
            }
        }
        return false; //no such user in the list

    }

    public boolean login(String username, String password) {
        for (AdminUser user : allAdminUsers) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    user.setIsSignedIn(true);
                    user.appendLoginHistory(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false; //no such user in the list
    }

    public void appendToList(AdminUser user) {
        allAdminUsers.add(user);
    }


    public boolean deleteUser(String username) {
        // assumes the user that gets delete is a non_admin user

        for (NormalUser user : normalManager.getAllNormalUsers()) {
            if (user.getUsername().equals(username)) {
                normalManager.removeFromList(user);
                return true;
            }
        }
        return false; //no such user in allNormalUsers (deletion not successful)
    }

    public List<String> getLoginHistory(String username) {
        //Assumes this user is in the list of allAdminUsers//
        for (AdminUser user : allAdminUsers) {
            if (user.getUsername().equals(username)) {
                return user.getLoginHistory();
            }
        }
        return null; //no such user in the list

    }

    public boolean banUser(String username) {
        if (checkInList(username)) {
            return false;
        } else {
            for (NormalUser user : normalManager.getAllNormalUsers()) {
                if (user.getUsername().equals(username)) {
                    user.setBanDate();
                }

            }return true;
        }


        // when we impliment the controller for banning user, we need to first make sure that we check if the user that is
        // trying to bansome one is not an admin, we will return "Sorry you are not an admin."
    }
}
