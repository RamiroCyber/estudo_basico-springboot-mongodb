package com.estudo.mongodb.estudomongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodb.estudomongodb.entities.Post;
import com.estudo.mongodb.estudomongodb.repositories.PostRepository;
import com.estudo.mongodb.estudomongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Optional<Post> findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			return post;
		}
		throw new ObjectNotFoundException("User not found");
	}
}
