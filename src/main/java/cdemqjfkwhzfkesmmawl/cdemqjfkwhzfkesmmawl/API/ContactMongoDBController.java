package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.API;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls.ContactMongoDBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/secondContacts")
public class ContactMongoDBController {

    @Autowired
    private ContactMongoDBServiceImpl contactMongoDBService;

    @GetMapping
    public List<ContactMongoDB> getAllContacts(){
        return contactMongoDBService.getAllContacts();
    }
}
