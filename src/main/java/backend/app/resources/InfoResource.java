package backend.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.app.entities.Info;
import backend.app.services.InfoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/infos")
public class InfoResource {
    @Autowired
    private InfoService infoService;

    @GetMapping
    public ResponseEntity<List<Info>> getAll() {
        return new ResponseEntity<>(infoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Info> get(@PathVariable String id) {
        return new ResponseEntity<>(infoService.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Info> save(@Valid @RequestBody Info info) {
        return new ResponseEntity<>(infoService.save(info), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        infoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
