package com.estudo.mongodb.estudomongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.mongodb.estudomongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> findByid(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok().body(postService.findById(id));
	}

} 