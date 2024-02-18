package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactSQLDto {
    private Long id;
    private String name;
    private String dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
}
