package driver;

import controllers.AdminController;


import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * This is the Shell that prompts user for input
 */
public class LoginSystem {
    private AdminController adminController = new AdminController();

    public static void main(String[] args) {
        System.out.println("Input A to login, input B to create account. " +
                "your input: ");
        Scanner sc = new Scanner(System.in);
        String task = sc.next();
        if (task.equals("A")) {
            System.out.println("Enter your username :");
            String username = sc.next();
            System.out.println("Enter your password :");
            String password = sc.next();
            
        } else if (task.equals("B")) {
            System.out.println("Enter your desired username: ");

        }
        System.out.println(task);
        System.out.println("Enter your username: ");
        Scanner sc2 = new Scanner(System.in);
        String username = sc2.next();
        System.out.println(username); // change this line to call controller
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(c.getTime());
    }
}
