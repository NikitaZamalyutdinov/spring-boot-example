package server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import server.domain.UserRepository;
import server.domain.UserRepository;

@Configuration
public class MainRepositoryConfiguration {

    @Autowired
    private UserRepository userRepositoryDb;

    /*@Bean
    public UserRepository injectUserRepository() {
        return userRepositoryDb;
    }*/
}
