package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactMongoDBRepository extends MongoRepository<ContactMongoDB,Long> {
}
