package com.estudo.mongodb.estudomongodb.services;

import java.awt.print.Pageable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.estudo.mongodb.estudomongodb.entities.User;
import com.estudo.mongodb.estudomongodb.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> getAll(Pageable pageable) {
		return userRepository.findAllUsers(pageable);
	}

	public Optional<User> findById(String id) {
		return (userRepository.findById(id));
	}
}
