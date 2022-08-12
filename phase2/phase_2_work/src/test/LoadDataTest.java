import GUI.GuiChooseLanguage;
import controllers.ShellState;
import driver.LoadData;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoadDataTest {

    @Test
    //Test the process of initializing data.
    public void testLoadData(){
        try {
            LoadData loadData = new LoadData();
            loadData.loadInitialSongs();
            ShellState shell = loadData.loadCurrentData();
            assertNotNull(shell.getLoginController());
            assertNotNull(shell.getSongController());
            assertNotNull(shell.getNotificationController());
            assertTrue(shell.getSongController().hasSong("Ghost"));
        } catch(IOException | ClassNotFoundException e){

            fail();



        }
    }

}
