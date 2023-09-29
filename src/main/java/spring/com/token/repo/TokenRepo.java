package spring.com.token.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import spring.com.token.entity.TokenEntity;

@Repository
public interface TokenRepo extends MongoRepository<TokenEntity, String>{

}
