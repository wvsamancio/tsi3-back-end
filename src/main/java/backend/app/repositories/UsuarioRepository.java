package backend.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.app.entities.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
