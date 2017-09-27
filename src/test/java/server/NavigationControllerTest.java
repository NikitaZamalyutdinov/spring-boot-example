package server;

import org.junit.Assert;
import org.junit.Test;
import server.Data.UserRepository;

public class NavigationControllerTest {

    UserRepository userRepository = new UserRepository();
    NavigationController cont = new NavigationController();

    @Test
    public void testA() {
        String name = "Nikita";
        String pass = "123";

        Assert.assertTrue(cont.isFoundUser(name, pass));
    }

    @Test
    public void testB() {
        String name = "Nikita";
        String pass = "222";

        Assert.assertFalse(cont.isFoundUser(name, pass));
    }
}