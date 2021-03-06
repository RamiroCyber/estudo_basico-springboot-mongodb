package com.estudo.mongodb.estudomongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.estudo.mongodb.estudomongodb.entities.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{
	
	boolean existsByEmail(String email);

}
