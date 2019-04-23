package com.vermeg.services.dto;

import java.util.List;

import com.vermeg.services.model.Role;

import io.swagger.annotations.ApiModelProperty;

public class UserDataDTO {

	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	List<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
