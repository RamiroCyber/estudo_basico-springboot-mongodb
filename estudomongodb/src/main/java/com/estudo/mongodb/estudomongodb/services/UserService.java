package com.estudo.mongodb.estudomongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.estudo.mongodb.estudomongodb.entities.User;
import com.estudo.mongodb.estudomongodb.repositories.UserRepository;
import com.estudo.mongodb.estudomongodb.services.exceptions.ObjectExistsException;
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

	@Transactional
	public User saveUser(User user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new ObjectExistsException("User not save"); // TESTE
		}
		return userRepository.save(user);
	}

	@Transactional
	public void deleteUser(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(String id, User user) {
		User newUser = userRepository.findById(id);
		
		
	}
}
