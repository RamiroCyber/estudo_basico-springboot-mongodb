package com.estudo.mongodb.estudomongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.mongodb.estudomongodb.entities.User;
import com.estudo.mongodb.estudomongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Page<User>> getAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok().body(userService.getAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findByid(@PathVariable(value = "id") String id){
		
		return ResponseEntity.ok().body(userService.findById(id));
	}

}
