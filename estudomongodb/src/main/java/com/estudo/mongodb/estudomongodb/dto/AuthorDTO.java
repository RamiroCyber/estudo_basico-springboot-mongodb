package com.estudo.mongodb.estudomongodb.dto;

import javax.validation.constraints.NotBlank;

import com.estudo.mongodb.estudomongodb.entities.User;

public class AuthorDTO {

	@NotBlank
	private String id;
	@NotBlank
	private String name;

	public AuthorDTO() {
	}

	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
