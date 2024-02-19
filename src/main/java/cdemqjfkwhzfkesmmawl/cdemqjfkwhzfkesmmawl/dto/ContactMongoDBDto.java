package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMongoDBDto {
    private String id;
    private String name;
    private String dateOfBirth;
    private String firstPhoneNumber;
    private String secondPhoneNumber;
}
