package com.vermeg.services.dto;

import java.util.Set;

import com.vermeg.services.model.User;

import io.swagger.annotations.ApiModelProperty;

public class UserGroupDTO {

	@ApiModelProperty(position = 0)
	private String name;

	@ApiModelProperty(position = 1)
	private Set<User> users;

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
