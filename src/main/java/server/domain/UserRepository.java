package server.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import server.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
