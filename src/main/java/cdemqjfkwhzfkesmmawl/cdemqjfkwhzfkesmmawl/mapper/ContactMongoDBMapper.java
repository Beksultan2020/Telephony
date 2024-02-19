package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.mapper;



import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactMongoDBDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMongoDBMapper {
    ContactMongoDBDto toDto(ContactMongoDB contactMongoDB);

    ContactMongoDB toEntity(ContactMongoDBDto contactMongoDBDto);

    List<ContactMongoDBDto> toDtoList(List<ContactMongoDB> contactMongoDBS);

    List<ContactMongoDB> toEntityList(List<ContactMongoDBDto> contactMongoDBDtos);
}
