package server.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/test.properties")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserRepositoryDbTest {

    @Autowired
    private UserRepositoryDb repository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setName("Nikita");
        user.setPassword("123");
        user.setShortName("NZ");
        user.setAvatar("1");
        repository.save(user);
    }

}