package com.example.JsonToCsv.Repository;

import com.example.JsonToCsv.PayLoad.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends MongoRepository<User,String> {

}
