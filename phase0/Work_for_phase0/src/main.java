import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        System.out.println("What do you want to do Today? Sign in?(type A) enter: ");
        Scanner sc = new Scanner(System.in);
        String task = sc.next();
        System.out.println(task);
    }
}
