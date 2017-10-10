package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("server.domain")
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
