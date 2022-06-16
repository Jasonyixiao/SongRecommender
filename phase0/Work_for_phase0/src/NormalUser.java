public class NormalUser extends User{
    public NormalUser(String username, String password) {
        super(username, password);
    }


    public void setIsAdmin(int i) {
        System.out.println("As a NormalUser, you can't make a normal user admin.");
    }
}
