package tests;

import controllers.ShellState;
import driver.LoginSystem;
import commands.CommandController;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UniteTest {
    LoginSystem loginSystem;
    CommandController commandExecutor;
    ShellState shellstate;

    @Before
    public void setUp() throws Exception {
        loginSystem = new LoginSystem();
        commandExecutor = new CommandController(shellstate);
    }
    @After
    public void tearDown() throws Exception {
    }

    // test constructor
    @Test
    public void testgetIsSignedIn() {
        try {
            HashMap<String, Commands> output = commandExecutor.getCommandMap();
            boolean getissignedin = shellstate.getIsSignedIn();
            assertEquals("T", getissignedin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}