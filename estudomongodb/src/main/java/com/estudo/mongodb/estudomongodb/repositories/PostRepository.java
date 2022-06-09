package com.estudo.mongodb.estudomongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudo.mongodb.estudomongodb.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
