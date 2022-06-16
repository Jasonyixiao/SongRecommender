import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminManager {
    private List<AdminUser> all_admin_users;
    private NormalUserManager normal_manager;


    public AdminManager(){
        all_admin_users = new ArrayList<AdminUser>();
    }

    public void create_admin_user(String username, String password){   //在controller里叫这个之前要先check我有没有已经登录as admin
        AdminUser new_admin_user = new AdminUser(username, password);
        append_to_list(new_admin_user);
        // @Henry： 这里要在database里加新user的信息

    }
    public List<AdminUser> getAll_admin_users(){
        return all_admin_users;
    }

    //public boolean check_in_list(String username){  //这个也许要放到controller里
    //    for(AdminUser user: all_admin_users){
    //        if (user.getUsername().equals(username)){
    //            return true;
    //        }
    //    }
    //    return false;
    //}

    private boolean check_log_in(String username ){             //这个method是用来在controller里叫的
                                                                // 比如我在没有以admin登陆前是不能delete别人的
        for(AdminUser user: all_admin_users){
            if (user.getUsername().equals(username)){
                return user.getIs_signed_in();
            }
        }
        return false; //no such user in the list

    }

    public boolean login(String username, String password){
        for(AdminUser user: all_admin_users){
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password)){
                    user.setIs_signed_in(true);
                    user.appendLogin_history(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false; //no such user in the list
    }

    public void append_to_list(AdminUser user){
        all_admin_users.add(user);
    }


    // @jason: ban人的method交给你了 爱你
    // public void ban_user(AdminUser adminUser){}

    public boolean delete_user( String username){
        // assumes the user that gets delete is a non_admin user
        // @Selena 在controller里叫这个method前要先check这个是不是
        // non admin
        // @Selena 在controller里叫delete_user前最好要先叫一下 NormalUserManager.check_in_list(见上面我comment掉的)。
        // 因为这里我们assume想要删掉的人已经是non_admin并且我已经以admin登录

        for (NormalUser user: normal_manager.getAll_normal_users()){
            if(user.getUsername().equals(username)){
                normal_manager.remove_from_list(user);
            }
        }
        return false; //no such user in all_normal_users (deletion not successful)
    }

    public List<String> get_login_history (String username){
        //Assumes this user is in the list of all_admin_users//
        for(AdminUser user: all_admin_users){
            if (user.getUsername().equals(username)){
                return user.getLogin_history();
            }
        }
        return null; //no such user in the list
    }




}
