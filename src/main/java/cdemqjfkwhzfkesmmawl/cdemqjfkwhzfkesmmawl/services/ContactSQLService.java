package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;

import java.util.List;

public interface ContactSQLService {
    List<ContactSQLDto> getAllContacts();

    List<ContactSQLDto> getAllContactsFiltered(int limit, int offset);

    ContactSQLDto getContactById(Long id);

    ContactSQLDto getContactByPhoneNumber(String phoneNumber);

    ContactSQLDto createContact(ContactSQL contactSQL);

    ContactSQLDto updateContactById(ContactSQLDto contactSQLDto);

    ContactSQLDto updateContactByPhoneNumber(ContactSQLDto contactSQLDto);

    void deleteContactById(Long id);

    void deleteContactByPhoneNumber(String phoneNumber);
}
