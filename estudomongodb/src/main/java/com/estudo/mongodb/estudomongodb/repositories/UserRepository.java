package com.estudo.mongodb.estudomongodb.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudo.mongodb.estudomongodb.entities.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{

	Page<User> findAllUsers(Pageable pageable);

}
