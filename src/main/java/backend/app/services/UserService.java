package backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.entities.User;
import backend.app.exceptions.NotFoundException;
import backend.app.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        get(id);
        userRepository.deleteById(id);
    }

}
