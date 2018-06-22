package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.RoadSign;

public interface RoadSignRepository extends MongoRepository<RoadSign,String>{

}
