package cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.repositories;

import cdemqjfkwhzfkesmmawl.cdemqjfkwhzfkesmmawl.modal.ContactMongoDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactMongoDBRepository extends MongoRepository<ContactMongoDB,Long> {

    ContactMongoDB findById(String id);
    void deleteById(String id);
    ContactMongoDB findByFirstPhoneNumberAndSecondPhoneNumber(String firstPhoneNumber, String secondPhoneNumber);
    ContactMongoDB findByFirstPhoneNumberOrSecondPhoneNumber(String firstPhoneNumber, String secondPhoneNumber);
    void deleteByFirstPhoneNumberOrSecondPhoneNumber(String firstPhoneNumber, String secondPhoneNumber);
}
