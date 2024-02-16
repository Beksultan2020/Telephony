package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.API;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.Filter;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls.ContactSQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/firstContacts")
public class ContactControllerSQL {
    @Autowired
    private ContactSQLServiceImpl contactSQLServiceImpl;

    @GetMapping
    public List<ContactSQLDto> getAllContacts(){
        return contactSQLServiceImpl.getAllContacts();
    }

    @GetMapping(value = "{id}")
    public ContactSQLDto getContactById(@PathVariable(value = "id")Long id){
        return contactSQLServiceImpl.getContactById(id);
    }

    @GetMapping(value = "phone/{phoneNumber}")
    public ContactSQLDto getContactByPhoneNumber(@PathVariable(value = "phoneNumber")String phoneNumber){
        return contactSQLServiceImpl.getContactByPhoneNumber(phoneNumber);
    }

    @GetMapping(value = "filteredContacts")
    public List<ContactSQLDto> getAllFilteredContacts(@RequestBody Filter filter){
        return contactSQLServiceImpl.getAllContactsFiltered(filter);
    }

    @PostMapping
    public ContactSQLDto creatContact(@RequestBody ContactSQL contactSQL){
        return contactSQLServiceImpl.createContact(contactSQL);
    }

    @PutMapping(value = "{id}")
    public ContactSQLDto updateContactById(@PathVariable(value = "id")Long id,@RequestBody ContactSQLDto contactSQLDto){
        return contactSQLServiceImpl.updateContactById(id,contactSQLDto);
    }

    @PutMapping(value = "phone/{phoneNumber}")
    public ContactSQLDto updateContactByPhoneNumber(@PathVariable(value = "phoneNumber")String phoneNumber,@RequestBody ContactSQLDto contactSQLDto){
        return contactSQLServiceImpl.updateContactByPhoneNumber(phoneNumber,contactSQLDto);
    }

    @DeleteMapping(value = "{id}")
    public void deleteContactById(@PathVariable(value = "id") Long id){
        contactSQLServiceImpl.deleteContactById(id);
    }

    @DeleteMapping(value = "phone/{phoneNumber}")
    public void deleteContactByPhoneNumber(@PathVariable(value = "phoneNumber") String phoneNumber){
        contactSQLServiceImpl.deleteContactByPhoneNumber(phoneNumber);
    }


}
