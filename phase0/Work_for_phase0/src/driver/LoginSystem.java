package driver;

import usecases.userManager;

/**
 * This is the Shell that prompts user for input
 */
public class LoginSystem {


    public static void main(String[] args) {
            //File f = new File(driver.GateWay.userFile);
            //System.out.println(f.exists());
            GateWay g = new GateWay();
            userManager userManager = new userManager(g);
            userManager.createUser("aaa","bbb");
            userManager.createUser("a", "b");
            userManager.save();
            usecases.userManager n1 = new userManager(g);
            n1.read();
            System.out.println(n1.getAllUsers());

            //m.create_admin_user("aaa","bbb");
            //System.out.println(m.getAllAdminUsers());
            //m.save();
            //AdminManager.admindata a = new AdminManager.admindata();

            //g.save(new AdminManager.admindata());



    }
}
