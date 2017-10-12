package server.inmemory;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;
import server.domain.entity.User;

import java.util.*;

@Repository
public class UserRepositoryFake {
    private static List<User> users = ImmutableList.of(
            new User("Nikita", "123", "NZ", "1"),
            new User("Mike", "777", "MV", "2"));

    public User findByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst().get();
    }
}