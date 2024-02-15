package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;

import java.util.List;

public interface ContactSQLService {
    List<ContactSQLDto> getAllContacts();
    List<ContactSQLDto> getAllContactsFiltered(int limit,int offset);
    ContactSQLDto getContactById(Long id);
    ContactSQLDto createContact(ContactSQL contactSQL);
    ContactSQLDto updateContact(Long id,ContactSQLDto contactSQLDto);
    void deleteContact(Long id);
}
