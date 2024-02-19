package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.API;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactMongoDBDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.Filter;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls.ContactMongoDBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/secondContacts")
public class ContactMongoDBController {

    @Autowired
    private ContactMongoDBServiceImpl contactMongoDBService;

    @GetMapping
    public List<ContactMongoDBDto> getAllContacts(){
        return contactMongoDBService.getAllContacts();
    }

    @GetMapping(value = "{id}")
    public ContactMongoDBDto getContactById(@PathVariable(value = "id")String id){
        return contactMongoDBService.getContactById(id);
    }

    @GetMapping(value = "phone/{phoneNumber}")
    public ContactMongoDBDto getContactByPhoneNumber(@PathVariable(value = "phoneNumber")String phoneNumber){
        return contactMongoDBService.getContactByPhoneNumber(phoneNumber);
    }


    @PostMapping
    public ContactMongoDBDto creatContact(@RequestBody ContactMongoDB contactMongoDB){
        return contactMongoDBService.createContact(contactMongoDB);
    }

    @PutMapping(value = "{id}")
    public ContactMongoDBDto updateContactById(@PathVariable(value = "id")String id,@RequestBody ContactMongoDBDto contactMongoDBDto){
        return contactMongoDBService.updateContactById(id,contactMongoDBDto);
    }

    @PutMapping(value = "phone/{phoneNumber}")
    public ContactMongoDBDto updateContactByPhoneNumber(@PathVariable(value = "phoneNumber")String phoneNumber,@RequestBody ContactMongoDBDto contactMongoDBDto){
        return contactMongoDBService.updateContactByPhoneNumber(phoneNumber,contactMongoDBDto);
    }

    @DeleteMapping(value = "{id}")
    public void deleteContactById(@PathVariable(value = "id") String id){
        contactMongoDBService.deleteContactById(id);
    }

    @DeleteMapping(value = "phone/{phoneNumber}")
    public void deleteContactByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber){
        contactMongoDBService.deleteContactByPhoneNumber(phoneNumber);
    }
}
