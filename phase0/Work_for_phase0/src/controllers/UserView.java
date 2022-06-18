package controllers;

@Controller
public class UserView {
    public void printUserDetails(String UserName, String id){
        System.out.println(UserName);
        System.out.println("ID No: " + id);
    }
}
