package com.estudo.mongodb.estudomongodb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudo.mongodb.estudomongodb.entities.User;
import com.estudo.mongodb.estudomongodb.repositories.UserRepository;

@SpringBootApplication
public class EstudomongodbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EstudomongodbApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		

		var larissa = new User(null, "maria", "larissa@gmail.com");
		var ramiro = new User(null, "Ramiro", "ramiro@gmail.com");
		var maria = new User(null, "maria", "maria@gmail.com");

		userRepository.saveAll(Arrays.asList(larissa, ramiro, maria));
	}

}
