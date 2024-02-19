package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactMongoDBDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.mapper.ContactMongoDBMapper;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.Filter;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories.ContactMongoDBRepository;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.ContactMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ContactMongoDBServiceImpl implements ContactMongoDBService {

    @Autowired
    private ContactMongoDBRepository contactMongoDBRepository;
    @Autowired
    private ContactMongoDBMapper contactMongoDBMapper;

    @Override
    public List<ContactMongoDBDto> getAllContacts() {
        List<ContactMongoDB> contactMongoDB = contactMongoDBRepository.findAll();
        return contactMongoDBMapper.toDtoList(contactMongoDB);
    }

    @Override
    public ContactMongoDBDto getContactById(String id) {
        ContactMongoDB contactMongoDB = contactMongoDBRepository.findById(id);
        if (contactMongoDB!=null){
            return contactMongoDBMapper.toDto(contactMongoDB);
        }
        return null;
    }

    @Override
    public ContactMongoDBDto getContactByPhoneNumber(String phoneNumber) {
        ContactMongoDB contactMongoDB = contactMongoDBRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber);
        if (contactMongoDB != null) {
            return contactMongoDBMapper.toDto(contactMongoDB);
        }
        return null;
    }

    @Override
    public ContactMongoDBDto createContact(ContactMongoDB contactSQL) {
        ContactMongoDB findContactMongoDB = contactMongoDBRepository.findByFirstPhoneNumberAndSecondPhoneNumber(contactSQL.getFirstPhoneNumber(), contactSQL.getSecondPhoneNumber());
        if (findContactMongoDB == null) {
            ContactMongoDB newContactMongoDB = new ContactMongoDB();
            newContactMongoDB.setName(contactSQL.getName());
            newContactMongoDB.setDateOfBirth(contactSQL.getDateOfBirth());
            newContactMongoDB.setFirstPhoneNumber(contactSQL.getFirstPhoneNumber());
            newContactMongoDB.setSecondPhoneNumber(contactSQL.getSecondPhoneNumber());
            newContactMongoDB.setCreationDate(LocalDate.now());

            ContactMongoDB saveInDto = contactMongoDBRepository.save(newContactMongoDB);
            return contactMongoDBMapper.toDto(saveInDto);
        }
        return null;
    }

    @Override
    public ContactMongoDBDto updateContactById(String id, ContactMongoDBDto contactMongoDBDto) {
        ContactMongoDB contactMongoDB = contactMongoDBRepository.findById(id);
        if (contactMongoDB!=null) {
            contactMongoDB.setName(contactMongoDBDto.getName());
            contactMongoDB.setDateOfBirth(contactMongoDBDto.getDateOfBirth());
            contactMongoDB.setFirstPhoneNumber(contactMongoDBDto.getFirstPhoneNumber());
            contactMongoDB.setSecondPhoneNumber(contactMongoDBDto.getSecondPhoneNumber());

            ContactMongoDB updatedContact = contactMongoDBRepository.save(contactMongoDB);
            return contactMongoDBMapper.toDto(updatedContact);
        }
        return null;
    }

    @Override
    public ContactMongoDBDto updateContactByPhoneNumber(String phoneNumber, ContactMongoDBDto contactMongoDBDto) {
        ContactMongoDB contactMongoDB = contactMongoDBRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber,phoneNumber);
        if (contactMongoDB!=null) {
            contactMongoDB.setName(contactMongoDBDto.getName());
            contactMongoDB.setDateOfBirth(contactMongoDBDto.getDateOfBirth());
            contactMongoDB.setFirstPhoneNumber(contactMongoDBDto.getFirstPhoneNumber());
            contactMongoDB.setSecondPhoneNumber(contactMongoDBDto.getSecondPhoneNumber());

            ContactMongoDB updatedContact = contactMongoDBRepository.save(contactMongoDB);
            return contactMongoDBMapper.toDto(updatedContact);
        }
        return null;
    }

    @Override
    public void deleteContactById(String id) {
        contactMongoDBRepository.deleteById(id);
    }

    @Override
    public void deleteContactByPhoneNumber(String phoneNumber) {
        ContactMongoDB contactMongoDB = contactMongoDBRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber);
        if (contactMongoDB != null) {
            contactMongoDBRepository.deleteByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber);
        }
    }
}
