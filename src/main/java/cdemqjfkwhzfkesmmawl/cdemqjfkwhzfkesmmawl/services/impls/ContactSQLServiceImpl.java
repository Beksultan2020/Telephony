package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.mapper.ContactSQLMapper;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories.ContactSQLRepository;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.ContactSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ContactSQLDto createContact(ContactSQL contactSQL) {
        return null;
    }

    @Override
    public ContactSQLDto updateContact(Long id, ContactSQLDto contactSQLDto) {
        return null;
    }

    @Override
    public void deleteContact(Long id) {

    }
}
