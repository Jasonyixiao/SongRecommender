import entities.User;
import org.junit.*;
import java.util.ArrayList;

public class TopNineUserTests {

        // initial number of candies
        @Test(timeout = 50)
        public void testConstructor() {
            User testUser = new User("Luke", "Skywalker");
            Assert.assertEquals("Luke", testUser.getUsername());
            Assert.assertEquals("Skywalker", testUser.getPassword());

            Assert.assertFalse(testUser.isAdmin());

            Assert.assertEquals(new ArrayList<>(), testUser.getLoginHistory());

        }
        @Test(timeout = 50)
        public void MultipleUsers()
        {
            User testUser0 = new User("Luke", "Skywalker");
            User testUser1 = new User("Leah", "Skywalker");
            User testUser2 = new User("Hans", "Solo");

            Assert.assertEquals(0, testUser0.getId());
            Assert.assertEquals(1, testUser1.getId());
            Assert.assertEquals(2, testUser2.getId());
        }

    }
