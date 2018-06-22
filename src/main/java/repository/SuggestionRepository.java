package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spring.Suggestion;

@Repository
public interface SuggestionRepository extends MongoRepository<Suggestion,String>{

}
