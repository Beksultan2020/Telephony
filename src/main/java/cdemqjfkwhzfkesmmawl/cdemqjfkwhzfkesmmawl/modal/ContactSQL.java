package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactSQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String date_Of_Birth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private LocalDate creationDate;
}
