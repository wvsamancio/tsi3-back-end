package backend.app.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

public class ValidErrorsException {
    private List<String> errors;

    public ValidErrorsException(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(error -> {
            this.errors.add(error.getDefaultMessage());
        });
    }

    public List<String> getErrors() {
        return errors;
    }
}
