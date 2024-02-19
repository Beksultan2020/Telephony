package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories.ContactMongoDBRepository;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.ContactMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactMongoDBServiceImpl implements ContactMongoDBService {

    @Autowired
    private ContactMongoDBRepository contactMongoDBRepository;

    @Override
    public List<ContactMongoDB> getAllContacts() {
        return contactMongoDBRepository.findAll();
    }
}
