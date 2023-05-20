package backend.app.entities;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    String id;

    @NotEmpty(message = "CPF is required")
    @UniqueElements(message = "CPF already exists")
    String cpf;

    @NotEmpty(message = "Password is required")
    String password;

    String role;
}
