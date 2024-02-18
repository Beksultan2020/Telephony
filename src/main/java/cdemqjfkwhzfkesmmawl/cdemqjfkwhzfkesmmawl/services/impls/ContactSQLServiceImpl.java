package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.mapper.ContactSQLMapper;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.Filter;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories.ContactSQLRepository;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.ContactSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContactSQLServiceImpl implements ContactSQLService {
    @Autowired
    private ContactSQLRepository contactSQLRepository;
    @Autowired
    private ContactSQLMapper contactSQLMapper;

    @Override
    public List<ContactSQLDto> getAllContacts() {
        List<ContactSQL> contactSQLS = contactSQLRepository.findAll();
        return contactSQLMapper.toDtoList(contactSQLS);
    }

    @Override
    public List<ContactSQLDto> getAllContactsFiltered(Filter filter) {
        List<ContactSQL> contactSQLS=contactSQLRepository.findAllFilteredContacts(filter.getLimit(), filter.getOffset());
        return contactSQLMapper.toDtoList(contactSQLS);
    }

    @Override
    public ContactSQLDto getContactById(Long id) {
        ContactSQL contactSQL = contactSQLRepository.findById(id).orElseThrow();
        return contactSQLMapper.toDto(contactSQL);
    }

    @Override
    public ContactSQLDto getContactByPhoneNumber(String phoneNumber) {
        ContactSQL contactSQL = contactSQLRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber);
        if (contactSQL != null) {
            return contactSQLMapper.toDto(contactSQL);
        }
        /*else {
            throw new RuntimeException("Contact not found");
        }*/
        return null;
    }

    @Override
    public ContactSQLDto createContact(ContactSQL contactSQL) {
        ContactSQL findContactSQL = contactSQLRepository.findByFirstPhoneNumberAndSecondPhoneNumber(contactSQL.getFirstPhoneNumber(), contactSQL.getSecondPhoneNumber());
        if (findContactSQL == null) {
            ContactSQL newContactSQL = new ContactSQL();
            newContactSQL.setName(contactSQL.getName());
            newContactSQL.setDateOfBirth(contactSQL.getDateOfBirth());
            newContactSQL.setFirstPhoneNumber(contactSQL.getFirstPhoneNumber());
            newContactSQL.setSecondPhoneNumber(contactSQL.getSecondPhoneNumber());
            newContactSQL.setCreationDate(LocalDate.now());

            ContactSQL saveInDto = contactSQLRepository.save(newContactSQL);
            return contactSQLMapper.toDto(saveInDto);
        }
        return null;
    }

    // Надо доработать код для исключении и тд!
    @Override
    public ContactSQLDto updateContactById(Long id,ContactSQLDto contactSQLDto) {
        ContactSQL contactSQL = contactSQLRepository.findById(id).orElseThrow();
        contactSQL.setName(contactSQLDto.getName());
        contactSQL.setDateOfBirth(contactSQLDto.getDateOfBirth());
        contactSQL.setFirstPhoneNumber(contactSQLDto.getFirstPhoneNumber());
        contactSQL.setSecondPhoneNumber(contactSQLDto.getSecondPhoneNumber());

        ContactSQL updatedContact = contactSQLRepository.save(contactSQL);
        return contactSQLMapper.toDto(updatedContact);
    }

    @Override
    public ContactSQLDto updateContactByPhoneNumber(String phoneNumber,ContactSQLDto contactSQLDto) {
        ContactSQL contactSQL = contactSQLRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber,phoneNumber);
        if (contactSQL != null) {
            contactSQL.setName(contactSQLDto.getName());
            contactSQL.setDateOfBirth(contactSQLDto.getDateOfBirth());
            contactSQL.setFirstPhoneNumber(contactSQLDto.getFirstPhoneNumber());
            contactSQL.setSecondPhoneNumber(contactSQLDto.getSecondPhoneNumber());

            ContactSQL updatedContact = contactSQLRepository.save(contactSQL);
            return contactSQLMapper.toDto(updatedContact);
        }
        return null;
    }

    @Override
    public void deleteContactById(Long id) {
        contactSQLRepository.deleteById(id);
    }

    @Override
    public void deleteContactByPhoneNumber(String phoneNumber) {
        ContactSQL contactSQL = contactSQLRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber);
        if (contactSQL != null) {
            contactSQLRepository.deleteByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber);
        }
    }

}
