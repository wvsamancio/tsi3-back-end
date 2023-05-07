package backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.entities.Contribute;
import backend.app.exceptions.NotFoundException;
import backend.app.repositories.ContributeRepository;

@Service
public class ContributeService {
    @Autowired
    private final ContributeRepository contributeRepository;

    public ContributeService(ContributeRepository contributeRepository) {
        this.contributeRepository = contributeRepository;
    }

    public List<Contribute> getAll() {
        return contributeRepository.findAll();
    }

    public Contribute get(String id) {
        return contributeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Contribute not found"));
    }

    public Contribute save(Contribute contribute) {
        return contributeRepository.save(contribute);
    }

    public void delete(String id) {
        get(id);
        contributeRepository.deleteById(id);
    }
}
