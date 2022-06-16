import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NormalUserManager {
    private List<NormalUser> all_normal_users;

    public NormalUserManager(){
        all_normal_users = new ArrayList<NormalUser>();
    }
    public List<NormalUser> getAll_normal_users(){
        return all_normal_users;
    }

    public boolean login(String username, String password){
        for(NormalUser user: all_normal_users){
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

    public void create_normal_user(String username, String password){
        NormalUser new_normal_user = new NormalUser(username, password);
        append_to_list(new_normal_user);
        // @Henry： 这里要在database里加新user的信息

    }

    //public boolean check_in_list(String username){    这个也许要放到controller里因为method有点多了
    //    for(NormalUser user: all_normal_users){
    //        if (user.getUsername().equals(username)){
    //            return true;
    //        }
    //    }
    //    return false;
    //}

    private boolean check_log_in(String username ){             //这个method是用来在controller里叫的
                                                                // 比如我在没有登录前是不能看自己的history的
        for(NormalUser user: all_normal_users){
            if (user.getUsername().equals(username)){
                return user.getIs_signed_in();
            }
        }
        return false; //no such user in the list
    }

    public List<String> get_login_history (String username){
        //Assumes this user is in the list of all_admin_users//
        for(NormalUser user: all_normal_users){
            if (user.getUsername().equals(username)){
                return user.getLogin_history();
            }
        }
        return null; //no such user in the list
    }

    public void append_to_list(NormalUser user){
        all_normal_users.add(user);
    }
    public void remove_from_list(NormalUser user){
        all_normal_users.remove(user);
        //@Henry ： 这里我们删完人 得需要想办法把在我们的database里也把这个人删掉。要不然在这里删 要不然我们在controller里删、
    }
}
