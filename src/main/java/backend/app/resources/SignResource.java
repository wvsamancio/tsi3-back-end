package backend.app.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class SignResource {
    @GetMapping
    public ResponseEntity<String> sign() {
        return new ResponseEntity<>("You are authenticated", HttpStatus.OK);
    }
}
