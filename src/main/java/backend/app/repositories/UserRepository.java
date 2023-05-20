package backend.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.app.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
