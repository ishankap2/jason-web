package repository;

import org.springframework.stereotype.Repository;
import spring.Obstacle;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ObstacleRepository extends MongoRepository<Obstacle, String>{
	

}
