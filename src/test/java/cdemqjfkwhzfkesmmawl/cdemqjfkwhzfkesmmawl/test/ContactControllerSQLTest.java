package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.test;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.dto.ContactSQLDto;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls.ContactSQLServiceImpl;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@SpringBootTest
@Transactional
public class ContactControllerSQLTest {

    @Mock
    private ContactSQLServiceImpl contactSQLService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllContacts() {
        ContactSQLDto contact1 = createContact("John", "12.12.2001", "1234567890", "0987654321");
        ContactSQLDto contact2 = createContact("Jane", "01.01.1990", "9876543210", "1987654327");

        when(contactSQLService.getAllContacts()).thenReturn(Arrays.asList(contact1, contact2));

        List<ContactSQLDto> allContacts = contactSQLService.getAllContacts();

        assertNotNull(allContacts);
        assertEquals(2, allContacts.size());
        assertEquals(contact1.getName(), allContacts.get(0).getName());
        assertEquals(contact2.getName(), allContacts.get(1).getName());
    }

    private ContactSQLDto createContact(String name, String dateOfBirth, String firstPhoneNumber, String secondPhoneNumber) {
        ContactSQL contact = new ContactSQL();
        contact.setName(name);
        contact.setDateOfBirth(dateOfBirth);
        contact.setFirstPhoneNumber(firstPhoneNumber);
        contact.setSecondPhoneNumber(secondPhoneNumber);
        return contactSQLService.createContact(contact);
    }
}
