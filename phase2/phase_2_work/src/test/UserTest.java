
import controllers.LoginController;
import controllers.ShellState;
import controllers.UserController;
import controllers.UserProfile;
import driver.GateWay;
import driver.LoadData;
import entities.User;
import org.junit.*;
import usecases.IGateWay;
import usecases.UserManager;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test methods that modify information regarding user's account.
 */
public class    UserTest {

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
        UserController userController = new UserController(userManager);
        userController.createNormalUser("Harry", "Zhang");
        assertTrue(userManager.hasUser("Harry"));

    }
    @Test
    // test logout
    public void testLogOff(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        userManager.createUser("Harry", "Zhang");
        UserProfile userProfile = loginController.Login("Harry","Zhang");
        loginController.LogOff(userProfile);
        assertFalse(userProfile.getIsSignedIn());

    }


    @Test
    // test login a user.
    public void testLogin(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        UserController userController = new UserController(userManager);
        LoginController loginController = new LoginController(userController);
        userManager.createUser("Harry", "Zhang");
        UserProfile userProfile =loginController.Login("Harry", "Zhang");
        assertNotNull(userProfile);

        assertSame(loginController.getUserController(), userController);

    }
    @Test
    // test check login history
    public void testGetLoginHistory(){
        IGateWay g = new GateWay();
        UserManager userManager = new UserManager(g);
        UserController userController = new UserController(userManager);

        userController.createNormalUser("Harry", "Zhang");
        userManager.login("Harry", "Zhang");
        assertNotNull(userController.getLogInHistory("Harry"));



    }
    @Test
    //Test promotion
    public void testPromotion(){
        IGateWay g = new GateWay();
        UserManager userManager1 = new UserManager(g);
        UserController userController = new UserController(userManager1);
        userController.createNormalUser("Harry", "Zhang");
        userManager1.getAllUsers().get("Harry").setIsAdmin(1);
        assertTrue(userController.isAdmin("Harry"));
        userController.createNormalUser("Jason", "Zhang");
        assertFalse(userController.isAdmin("Jason"));
        assertEquals("Command Successful!",userController.createAdminUser("Harry","Jason"));
        assertTrue(userController.isAdmin("Jason"));
    }
    @Test
    //Test admin user delete a normal user.
    public void testDelete(){
        IGateWay g = new GateWay();
        UserManager userManager1 = new UserManager(g);
        UserController userController = new UserController(userManager1);
        userController.createNormalUser("Harry", "Zhang");
        userManager1.getAllUsers().get("Harry").setIsAdmin(1);
        userController.createNormalUser("Jason", "Zhang");
        assertEquals("Command Successful!",userController.deleteUser("Harry","Jason"));
        assertFalse(userManager1.getAllUsers().containsKey("Jason"));




    }
    @Test
    // test if only admin user can ban normal user.
    public void testBan(){
        IGateWay g = new GateWay();
        UserManager userManager1 = new UserManager(g);
        UserController userController = new UserController(userManager1);
        userController.createNormalUser("Harry", "Zhang"); //We designed the program to have the first user be
                                                                    //Admin.
        userController.createNormalUser("Jason", "Zhang");
        userController.createNormalUser("123","123");

        assertEquals("Command Successful!", userController.banUser("Harry","Jason"));
        assertEquals("You are not an admin.", userController.banUser("Jason", "Harry"));
        userController.createAdminUser("Harry", "Jason");
        userController.createAdminUser("Jason", "123");
        assertEquals("You cannot ban admin.", userController.banUser("Jason","123"));

    }

    @Test
    //Test if user information persists after it logs in.

    public void testUserProfile() {
        LoadData loadData = new LoadData();
        try {
            ShellState shell = loadData.loadCurrentData();
            IGateWay g = new GateWay();
            UserManager userManager = new UserManager(g);
            UserController userController = new UserController(userManager);
            LoginController loginController = new LoginController(userController);
            userManager.createUser("Harry12", "Zhang");
            UserProfile userProfile =loginController.Login("Harry12", "Zhang");
            shell.setUserProfile(userProfile);
            assertEquals("Harry12",shell.getUserProfile().getUsername());
        }catch(IOException | ClassNotFoundException e){
            fail();

        }

    }






}
