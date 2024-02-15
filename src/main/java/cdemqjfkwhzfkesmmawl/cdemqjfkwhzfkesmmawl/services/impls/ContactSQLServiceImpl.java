package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.mapper.ContactSQLMapper;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
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
        List<ContactSQL> contactSQLS=contactSQLRepository.findAll();
        return contactSQLMapper.toDtoList(contactSQLS);
    }

    @Override
    public List<ContactSQLDto> getAllContactsFiltered(int limit, int offset) {
        return null;
    }

    @Override
    public ContactSQLDto getContactById(Long id) {
        ContactSQL contactSQL=contactSQLRepository.findById(id).orElseThrow();
        return contactSQLMapper.toDto(contactSQL);
    }

    @Override
    public ContactSQLDto getContactByPhoneNumber(String phoneNumber) {
        ContactSQL contactSQL=contactSQLRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber,phoneNumber);
        if (contactSQL!=null){
            return contactSQLMapper.toDto(contactSQL);
        }
        /*else {
            throw new RuntimeException("Contact not found");
        }*/
        return null;
    }

    @Override
    public ContactSQLDto createContact(ContactSQL contactSQL) {
        ContactSQL findContactSQL=contactSQLRepository.findByFirstPhoneNumberAndSecondPhoneNumber(contactSQL.getFirstPhoneNumber(), contactSQL.getSecondPhoneNumber());
        if(findContactSQL==null){
            ContactSQL newContactSQL=new ContactSQL();
            newContactSQL.setName(contactSQL.getName());
            newContactSQL.setDate_Of_Birth(contactSQL.getDate_Of_Birth());
            newContactSQL.setFirstPhoneNumber(contactSQL.getFirstPhoneNumber());
            newContactSQL.setSecondPhoneNumber(contactSQL.getSecondPhoneNumber());
            newContactSQL.setCreationDate(LocalDate.now());

            ContactSQL saveInDto=contactSQLRepository.save(newContactSQL);
            return contactSQLMapper.toDto(saveInDto);
        }
        return null;
    }

    @Override
    public ContactSQLDto updateContact(Long id, ContactSQLDto contactSQLDto) {
        return null;
    }

    @Override
    public void deleteContactById(Long id) {
        contactSQLRepository.deleteById(id);
    }

    @Override
    public void deleteContactByPhoneNumber(String phoneNumber) {
        ContactSQL contactSQL=contactSQLRepository.findByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber,phoneNumber);
        if (contactSQL!=null){
            contactSQLRepository.deleteByFirstPhoneNumberOrSecondPhoneNumber(phoneNumber,phoneNumber);
        }
    }
}
