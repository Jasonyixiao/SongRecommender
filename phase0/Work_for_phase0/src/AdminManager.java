import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminManager {
    private List<AdminUser> allAdminUsers;
    private NormalUserManager normalManager;


    public AdminManager(){
        allAdminUsers = new ArrayList<AdminUser>();
    }

    public void create_admin_user(String username, String password){   //在controller里叫这个之前要先check我有没有已经登录as admin
        AdminUser new_admin_user = new AdminUser(username, password);
        appendToList(new_admin_user);
        // @Henry： 这里要在database里加新user的信息

    }
    public List<AdminUser> getAllAdminUsers(){
        return allAdminUsers;
    }

//     public boolean checkInList(String username){  //这个也许要放到controller里
//        for(AdminUser user: allAdminUsers){
//            if (user.getUsername().equals(username)){
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean checkLogIn(String username ){             //这个method是用来在controller里叫的
                                                                // 比如我在没有以admin登陆前是不能delete别人的
        for(AdminUser user: allAdminUsers){
            if (user.getUsername().equals(username)){
                return user.getIsSignedIn();
            }
        }
        return false; //no such user in the list

    }

    public boolean login(String username, String password){
        for(AdminUser user: allAdminUsers){
            if (user.getUsername().equals(username)){
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

    public void appendToList(AdminUser user){
        allAdminUsers.add(user);
    }


    // @jason: ban人的method交给你了 爱你
    // public void ban_user(AdminUser adminUser){}

    public boolean deleteUser( String username){
        // assumes the user that gets delete is a non_admin user
        // @Selena 在controller里叫这个method前要先check这个是不是
        // non admin
        // @Selena 在controller里叫delete_user前最好要先叫一下 NormalUserManager.check_in_list(见上面我comment掉的)。
        // 因为这里我们assume想要删掉的人已经是non_admin并且我已经以admin登录

        for (NormalUser user: normalManager.getAllNormalUsers()){
            if(user.getUsername().equals(username)){
                normalManager.removeFromList(user);
            }
        }
        return false; //no such user in allNormalUsers (deletion not successful)
    }

    public List<String> getLoginHistory (String username){
        //Assumes this user is in the list of allAdminUsers//
        for(AdminUser user: allAdminUsers){
            if (user.getUsername().equals(username)){
                return user.getLoginHistory();
            }
        }
        return null; //no such user in the list

    }

    public boolean banUser(User someUser){
        if (someUser instanceof AdminUser) {
            return false;
        } else {
            someUser.setBanDate();
            return true;
        }
    }

    // when we impliment the controller for banning user, we need to first make sure that we check if the user that is
    // trying to bansome one is not an admin, we will return "Sorry you are not an admin."


}
