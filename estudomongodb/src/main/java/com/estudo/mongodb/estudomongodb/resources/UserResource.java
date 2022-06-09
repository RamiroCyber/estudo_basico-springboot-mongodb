package com.estudo.mongodb.estudomongodb.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.mongodb.estudomongodb.dto.UserDTO;
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
	public ResponseEntity<Object> findByid(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Object> insertUser(@RequestBody @Valid UserDTO userDTO) {
		var user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") String id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Object> update(@PathVariable(value = "id") String id, @RequestBody @Valid UserDTO userDTO) {
		Optional<User> userOptional = userService.findById(id);
		var updatedUser = userOptional.get();
		updatedUser.setEmail(userDTO.getEmail());
		updatedUser.setName(userDTO.getName());
		return ResponseEntity.ok().body(userService.saveUser(updatedUser));
	}

}
