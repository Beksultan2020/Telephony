package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.Filter;

import java.util.List;

public interface ContactSQLService {
    List<ContactSQLDto> getAllContacts();

    List<ContactSQLDto> getAllContactsFiltered(Filter filter);

    ContactSQLDto getContactById(Long id);

    ContactSQLDto getContactByPhoneNumber(String phoneNumber);

    ContactSQLDto createContact(ContactSQL contactSQL);

    ContactSQLDto updateContactById(Long id,ContactSQLDto contactSQLDto);

    ContactSQLDto updateContactByPhoneNumber(String phoneNumber,ContactSQLDto contactSQLDto);

    void deleteContactById(Long id);

    void deleteContactByPhoneNumber(String phoneNumber);

}
