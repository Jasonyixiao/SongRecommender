import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NormalUserManager {
    private List<NormalUser> allNormalUsers;

    public NormalUserManager(){
        allNormalUsers = new ArrayList<NormalUser>();
    }
    public List<NormalUser> getAllNormalUsers(){
        return allNormalUsers;
    }

    public boolean login(String username, String password){
        for(NormalUser user: allNormalUsers){
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

    public void createNormalUser(String username, String password){
        NormalUser newNormalUser = new NormalUser(username, password);
        appendToList(newNormalUser);
        // @Henry： 这里要在database里加新user的信息

    }

//    public boolean checkInList(String username){    这个也许要放到controller里因为method有点多了
//        for(NormalUser user: allNormalUsers){
//            if (user.getUsername().equals(username)){
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean checkLogIn(String username ){             //这个method是用来在controller里叫的
                                                                // 比如我在没有登录前是不能看自己的history的
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
        //@Henry ： 这里我们删完人 得需要想办法把在我们的database里也把这个人删掉。要不然在这里删 要不然我们在controller里删、
    }

//    public void ban
}
