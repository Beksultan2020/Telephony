package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.mapper;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactSQLMapper {
    ContactSQLDto toDto(ContactSQL contactSQL);

    ContactSQL toEntity(ContactSQLDto contactSQLDto);

    List<ContactSQLDto> toDtoList(List<ContactSQL> contactSQLS);

    List<ContactSQL> toEntityList(List<ContactSQLDto> contactSQLDtos);
}
