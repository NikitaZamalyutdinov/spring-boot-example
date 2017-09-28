package server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import server.domain.TaskRepository;
import server.domain.UserRepository;

@Configuration
public class LectureRepositoryConfiguration {

    @Bean
    //@Profile("LECTURE")
    public UserRepository injectUserRepository() {
        return new UserRepository();
    }

    @Bean
    //@Profile("LECTURE")
    public TaskRepository injectTaskRepository() {
        return new TaskRepository();
    }
}
