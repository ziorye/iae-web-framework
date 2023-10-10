package com.ioewvsau.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class User {
	private Long id;
	private String name;
	private String email;
	@JsonIgnore
	private String password;
	private int status;

	@JsonIgnore
	List<Post> posts;
}
