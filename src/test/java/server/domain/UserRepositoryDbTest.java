package server.domain;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import server.domain.entity.User;

import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/test.properties")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserRepositoryDbTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setName("Artur");
        user.setPassword("123");
        user.setShortName("AD");
        user.setAvatar("Freddie-icon");
        repository.save(user);
    }

    @Test
    public void findAll() {
        Iterable<User> allUsers = repository.findAll();
        List<User> usersList = Lists.newArrayList(allUsers);

        Assert.assertTrue(usersList.size() == 2);
        Assert.assertTrue(usersList.get(0).getShortName().equals("AD"));
        Assert.assertTrue(usersList.get(1).getShortName().equals("NZ"));
    }

}