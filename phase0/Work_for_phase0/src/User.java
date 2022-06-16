import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class User {

    private String username;

    private String password;

    private int IsAdmin;

    private List<String> login_history;

    private boolean is_signed_in;

    //@Jason : 这里决定一下is_banned该用什么type，怎么设定他要被ban了多久？ maybe用倒计时？如果用倒计时的话 怎么把他存进csv

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.IsAdmin = 0;
        this.is_signed_in = false;
        login_history = new ArrayList<String>();
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

    public void appendLogin_history(String d){
        login_history.add(d);
    }

    public List<String> getLogin_history(){
        return login_history;
    }

    public boolean getIs_signed_in(){
        return is_signed_in;
    }

    public void setIs_signed_in(boolean b){
        this.is_signed_in = b;
    }


}
