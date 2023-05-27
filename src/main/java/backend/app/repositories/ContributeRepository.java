package backend.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import backend.app.entities.Contribute;

public interface ContributeRepository extends MongoRepository<Contribute, String> {
    @Query("{ 'username' : ?0 }")
    List<Contribute> findByUsername(String username);

    @Query("{ 'username' : ?0, 'id' : ?1 }")
    Optional<Contribute> findByUsernameAndId(String username, String id);
}
