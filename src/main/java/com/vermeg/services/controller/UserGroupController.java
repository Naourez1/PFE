package com.vermeg.services.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vermeg.services.cofiguration.api.PrefixedRestController;
import com.vermeg.services.dto.UserGroupDTO;
import com.vermeg.services.model.UserGroup;
import com.vermeg.services.services.UserGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@PrefixedRestController
@Api(tags = "user group")
public class UserGroupController {

	@Autowired
	private UserGroupService userGroupService;

	@Autowired
	private ModelMapper modelMapper;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/userGroup")
	@ApiOperation(value = "${UserGroupController.createUserGroup}", produces = "text/plain")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 401, message = "You are not authorized to access this information"),
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "UserGroup exist already"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<Long> createUserGroup(@RequestBody @Valid UserGroupDTO userGroupDTO) {
		Long id = userGroupService.create(modelMapper.map(userGroupDTO, UserGroup.class)).getId();
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/userGroup")
	@ApiOperation(value = "${UserGroupController.getAllUserGroups}", response = UserGroup.class, produces = "application/json")
	@ApiResponses(value = { //
			@ApiResponse(code = 302, message = "Data is found"),
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 401, message = "You are not authorized to access this information"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<List<UserGroup>> getAllUserGroups() {
		List<UserGroup> userGroupList = userGroupService.getAll();
		return new ResponseEntity<>(userGroupList, HttpStatus.FOUND);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/userGroup/{id}")
	@ApiOperation(value = "${UserGroupController.search}", response = UserGroup.class, produces = "application/json")
	@ApiResponses(value = { //
			@ApiResponse(code = 302, message = "Data is found"),
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 401, message = "You are not authorized to access this information"),
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 404, message = "The user doesn't exist"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public ResponseEntity<UserGroup> search(@ApiParam("userGroupId") @PathVariable Long id) {
		UserGroup userGroup = userGroupService.read(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return new ResponseEntity<>(userGroup, headers, HttpStatus.FOUND);
	}

}
