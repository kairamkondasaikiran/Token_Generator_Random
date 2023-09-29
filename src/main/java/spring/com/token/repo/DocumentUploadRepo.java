package spring.com.token.repo;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import spring.com.token.entity.DocumentUploadEntity;

public interface DocumentUploadRepo extends MongoRepository<DocumentUploadEntity, String>{

	DocumentUploadEntity findBy(BasicQuery basicQuery, Class<DocumentUploadEntity> class1);
	DocumentUploadEntity findByEmailId(String email);



}
