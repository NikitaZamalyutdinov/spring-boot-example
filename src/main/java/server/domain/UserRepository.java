package server.domain;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static List<User> users = ImmutableList.of(
            new User("Nikita", "123", "NZ", "1"),
            new User("Mike", "777", "MV", "2"));

    public boolean containsUser(User user){
        return users.stream().anyMatch(u -> u.equals(user));
    }

    public Optional<User> findByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst();
    }

    public static User getFakeUser(){
        return new User("Unknown", "", "Unknown", "1");
    }
}
