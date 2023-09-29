package spring.com.token.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spring.com.token.entity.FileData;

@Repository
public interface FileDataRepo extends MongoRepository<FileData, String>{

}
