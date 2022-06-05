package com.estudo.mongodb.estudomongodb.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.estudo.mongodb.estudomongodb.entities.User;
import com.estudo.mongodb.estudomongodb.repositories.UserRepository;
import com.estudo.mongodb.estudomongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> getAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Optional<User> findById(String id) {
		var user = userRepository.findById(id);
		if (user.isPresent()) {
			return user;
		}
		throw new ObjectNotFoundException("User not found");
	}
}
