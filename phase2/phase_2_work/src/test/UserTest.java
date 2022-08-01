
import driver.GateWay;
import entities.User;
import org.junit.*;
import usecases.IGateWay;
import usecases.UserManager;

import static org.junit.Assert.*;
public class UserTest {

    //Constructor
    @Test
    public void testUser(){
        IGateWay g = new GateWay();
        User u0 = new User("Harry", "Zhang");
        User u1 = new User("Jason", "Zhang");
        UserManager userManager = new UserManager(g);
    }
    // test registering a user
    @Test
    public void testRegister(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        userManager.createUser("Harry", "Zhang");
        assertTrue(userManager.hasUser("Harry"));

    }



    @Test
    // test login a user.
    public void testLogin(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        userManager.createUser("Harry", "Zhang");
        assertTrue(userManager.login("Harry", "Zhang"));

    }
    @Test
    // test check login history
    public void testGetLoginHistory(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        userManager.createUser("Harry", "Zhang");
        userManager.login("Harry", "Zhang");
        assertNotNull(userManager.getLoginHistory("Harry"));



    }
    @Test
    //Test promotion
    public void testPromotion(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        userManager.createUser("Harry", "Zhang");
        userManager.getAllUsers().get("Harry").setIsAdmin(1);
        userManager.createUser("Jason", "Zhang");
        assertEquals("Command successful.",userManager.createAdmin("Harry","Jason"));


    }
    @Test
    // test if only admin user can ban normal user.
    public void testBan(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        userManager.createUser("Harry", "Zhang"); //We designed the program to have the first user be
                                                                    //Admin.
        userManager.createUser("Jason", "Zhang");
        userManager.createUser("123","123");

        assertEquals("Command Successful!", userManager.banUser("Harry","Jason"));
        assertEquals("You are not an admin.", userManager.banUser("Jason", "Harry"));
        userManager.createAdmin("Harry", "Jason");
        userManager.createAdmin("Jason", "123");
        assertEquals("You cannot ban admin.", userManager.banUser("Jason","123"));



    }




}
