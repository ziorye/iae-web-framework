package com.ioewvsau.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
	private Long id;
	private String name;
	private String email;
	private String password;
	private int status;

	List<Post> posts;
}
