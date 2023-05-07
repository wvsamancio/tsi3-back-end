package backend.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "contact")
public class Contact {
    @Id
    private String id;

    @NotEmpty(message = "Icon is required")
    private String icon;

    @NotEmpty(message = "Label is required")
    private String label;

    @NotEmpty(message = "Value is required")
    private String value;
}
