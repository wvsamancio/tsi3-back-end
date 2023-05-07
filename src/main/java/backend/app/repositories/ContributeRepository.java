package backend.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.app.entities.Contribute;

public interface ContributeRepository extends MongoRepository<Contribute, String> {

}
