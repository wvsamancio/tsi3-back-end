package backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.app.entities.Usuario;
import backend.app.exceptions.NotFoundException;
import backend.app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario get(String id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Usuario not found"));
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(String id) {
        get(id);
        usuarioRepository.deleteById(id);
    }
}
