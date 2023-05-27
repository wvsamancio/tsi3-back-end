package backend.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import backend.app.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'username': ?0}")
    User findByUsername(String username);
}
