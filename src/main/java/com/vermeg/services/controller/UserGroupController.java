package com.vermeg.services.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.vermeg.services.cofiguration.api.PrefixedRestController;
import com.vermeg.services.dto.UserGroupDTO;
import com.vermeg.services.model.UserGroup;
import com.vermeg.services.services.UserGroupService;

import io.swagger.annotations.Api;

@PrefixedRestController
@Api(tags = "user group")
public class UserGroupController {

	@Autowired
	private UserGroupService userGroupService;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<?> createUserGroup(@RequestBody @Valid UserGroupDTO userGroupDTO) {
		Long id = userGroupService.create(modelMapper.map(userGroupDTO, UserGroup.class)).getId();
		return new ResponseEntity<Object>(id, HttpStatus.OK);
	}

}
