package com.estudo.mongodb.estudomongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodb.estudomongodb.entities.User;
import com.estudo.mongodb.estudomongodb.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public List<User> getAll(){
		return userRepository.findAll();
	}
}
