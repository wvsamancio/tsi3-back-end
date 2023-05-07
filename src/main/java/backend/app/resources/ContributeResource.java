package backend.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.app.entities.Contribute;
import backend.app.services.ContributeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contributions")
public class ContributeResource {
    @Autowired
    private ContributeService contributeService;

    @GetMapping
    public ResponseEntity<List<Contribute>> getAll() {
        return new ResponseEntity<>(contributeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contribute> get(@PathVariable String id) {
        return new ResponseEntity<>(contributeService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contribute> save(@Valid @RequestBody Contribute contribute) {
        return new ResponseEntity<>(contributeService.save(contribute), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        contributeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
