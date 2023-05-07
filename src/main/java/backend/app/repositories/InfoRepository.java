package backend.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.app.entities.Info;

public interface InfoRepository extends MongoRepository<Info, String> {

}
