import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        System.out.println("What do you want to do Today? input A if you want to promote, input B if delete. " +
                "your input: ");
        Scanner sc = new Scanner(System.in);
        String task = sc.next();
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
