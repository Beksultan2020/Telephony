package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ContactSQLRepository extends JpaRepository<ContactSQL,Long> {
    ContactSQL findByFirstPhoneNumberAndSecondPhoneNumber(String firstPhoneNumber,String secondPhoneNumber);

    ContactSQL findByFirstPhoneNumberOrSecondPhoneNumber(String firstPhoneNumber,String secondPhoneNumber);

    void deleteByFirstPhoneNumberOrSecondPhoneNumber(String firstPhoneNumber,String secondPhoneNumber);

    @Query("SELECT c FROM ContactSQL c ORDER BY c.id")
    List<ContactSQL> findAllFilteredContacts(int limit,int offset);
}
