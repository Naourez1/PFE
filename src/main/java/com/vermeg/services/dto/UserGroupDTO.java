package com.vermeg.services.dto;

import java.util.Set;

import com.vermeg.services.model.User;

public class UserGroupDTO {

	private Long id;

	private String name;

	private Set<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}