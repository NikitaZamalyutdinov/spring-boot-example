package server.domain;

import org.springframework.data.repository.CrudRepository;
import server.domain.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
