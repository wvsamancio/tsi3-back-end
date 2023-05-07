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
@Document(collection = "contribute")
public class Contribute {
    @Id
    private String id;

    @NotEmpty(message = "Content is required")
    private String content;

    @NotEmpty(message = "Department is required")
    private String department;

    @NotEmpty(message = "Latitude is required")
    private String lat;

    @NotEmpty(message = "Longitude is required")
    private String lng;

    @NotEmpty(message = "User is required")
    private String user;
}
