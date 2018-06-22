package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import repository.ObstacleRepository;
import repository.RoadSignRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {ObstacleRepository.class,RoadSignRepository.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}