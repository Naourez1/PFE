package com.vermeg.services.dto;

import java.util.List;

import com.vermeg.services.model.Role;

import io.swagger.annotations.ApiModelProperty;

public class UserResponseDTO {

	@ApiModelProperty(position = 0)
	private Integer id;
	@ApiModelProperty(position = 1)
	private String name;
	@ApiModelProperty(position = 2)
	private String username;
	@ApiModelProperty(position = 3)
	private String email;
	@ApiModelProperty(position = 4)
	List<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
