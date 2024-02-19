package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "ContactMongoDB")
public class ContactMongoDB {
    @Id
    private String id;

    private String name;
    private String dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private LocalDate creationDate;
}
