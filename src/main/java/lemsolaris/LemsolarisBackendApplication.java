package lemsolaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LemsolarisBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(LemsolarisBackendApplication.class, args);
    }
}
