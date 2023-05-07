package backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.entities.Contact;
import backend.app.exceptions.NotFoundException;
import backend.app.repositories.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    public Contact get(String id) {
        return contactRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Contact not found"));
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    public void delete(String id) {
        get(id);
        contactRepository.deleteById(id);
    }
}
