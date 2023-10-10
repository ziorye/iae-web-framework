package com.ioewvsau.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class User {
	private Long id;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String name;

	@Email(message = "The string has to be a well-formed email address")
	private String email;

	@JsonIgnore
	private String password;
	private int status;

	@JsonIgnore
	List<Post> posts;
}
