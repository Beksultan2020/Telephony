package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactMongoDBDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.Filter;

import java.util.List;

public interface ContactMongoDBService {
    List<ContactMongoDBDto> getAllContacts();


    ContactMongoDBDto getContactById(String id);

    ContactMongoDBDto getContactByPhoneNumber(String phoneNumber);

    ContactMongoDBDto createContact(ContactMongoDB contactSQL);

    ContactMongoDBDto updateContactById(String id,ContactMongoDBDto contactMongoDBDto);

    ContactMongoDBDto updateContactByPhoneNumber(String phoneNumber,ContactMongoDBDto contactMongoDBDto);

    void deleteContactById(String id);

    void deleteContactByPhoneNumber(String phoneNumber);
}
