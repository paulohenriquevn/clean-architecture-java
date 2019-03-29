package gateways.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "entities", "repository", "core" })
@EntityScan("entities")
public class TestConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(TestConfiguration.class, args);
    }

}
