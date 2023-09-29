package spring.com.token.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.com.token.entity.StreamAPIEntity;

public interface SteamAPIRepo extends MongoRepository<StreamAPIEntity, Integer>{

}
