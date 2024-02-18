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
    @Column(name = "date_Of_Birth")
    private String dateOfBirth;
    @Column(name = "first_phone_number")
    private String firstPhoneNumber;
    @Column(name = "second_phone_number")
    private String secondPhoneNumber;
    @Column(name = "creation_date")
    private LocalDate creationDate;
}
