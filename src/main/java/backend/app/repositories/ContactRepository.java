package backend.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.app.entities.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
