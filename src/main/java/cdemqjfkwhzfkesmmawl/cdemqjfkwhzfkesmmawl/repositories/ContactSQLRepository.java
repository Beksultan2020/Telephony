package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories;


import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContactSQLRepository extends JpaRepository<ContactSQL,Long> {
}
