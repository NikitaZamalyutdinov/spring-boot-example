package server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import server.inmemory.TaskRepositoryFake;
import server.inmemory.UserRepositoryFake;

@Configuration
public class LectureRepositoryConfiguration {

    /*@Bean
    @Profile("LECTURE")
    public UserRepositoryFake injectUserRepository() {
        return new UserRepositoryFake();
    }

    @Bean
    @Profile("LECTURE")
    public TaskRepositoryFake injectTaskRepository() {
        return new TaskRepositoryFake();
    }*/
}
