package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.test;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories.ContactSQLRepository;
import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.services.impls.ContactSQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@SpringBootTest
@Transactional
public class ContactControllerSQLTest {
    @Autowired
    private ContactSQLRepository contactSQLRepository;
    @Autowired
    private ContactSQLServiceImpl contactSQLService;

    @Test
}
