package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.API;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls.ContactSQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/firstContacts")
public class ContactControllerSQL {
    @Autowired
    private ContactSQLServiceImpl contactSQLServiceImpl;


}
