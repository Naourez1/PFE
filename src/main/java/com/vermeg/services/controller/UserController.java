package com.vermeg.services.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.services.cofiguration.api.PrefixedRestController;
import com.vermeg.services.dto.UserDataDTO;
import com.vermeg.services.dto.UserResponseDTO;
import com.vermeg.services.model.User;
import com.vermeg.services.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@PrefixedRestController
@Api(tags = "users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/auth/signin")
	@ApiOperation(value = "${UserController.signin}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 422, message = "Invalid username/password supplied") })
	public String login(//
			@ApiParam("Username") @RequestParam String username, //
			@ApiParam("Password") @RequestParam String password) {
		return userService.signin(username, password);
	}

	@PostMapping("/auth/signup")
	@ApiOperation(value = "${UserController.signup}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "Username is already in use"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public String signup(@ApiParam("Signup User") @RequestBody UserDataDTO user) {
		return userService.signup(modelMapper.map(user, User.class));
	}

	@DeleteMapping(value = "/user/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "${UserController.delete}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 404, message = "The user doesn't exist"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public Long delete(@ApiParam("UserId") @PathVariable Long id) {
		userService.delete(id);
		return id;
	}

	@GetMapping(value = "/user/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "${UserController.search}", response = UserResponseDTO.class)
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 404, message = "The user doesn't exist"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public UserResponseDTO search(@ApiParam("UserId") @PathVariable Long id) {
		return modelMapper.map(userService.search(id), UserResponseDTO.class);
	}

	@GetMapping(value = "/me")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_PM')")
	@ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class)
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public UserResponseDTO whoami(HttpServletRequest req) {
		return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
	}

	@GetMapping("/refresh")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_PM')")
	public String refresh(HttpServletRequest req) {
		return userService.refresh(req.getRemoteUser());
	}

	@PutMapping("/userput")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_PM')")
	@ApiOperation(value = "${UserController.updateUser}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 404, message = "The user doesn't exist"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public UserResponseDTO updateUser(@RequestBody @Valid UserDataDTO user) {
		return modelMapper.map(userService.save(modelMapper.map(user, User.class)), UserResponseDTO.class);
	}

	@GetMapping("/users")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "${UserController.getUsers}", response = UserResponseDTO.class)
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public List<UserResponseDTO> getUsers() {
		return userService.getAll().stream().map(entity -> modelMapper.map(entity, UserResponseDTO.class))
				.collect(Collectors.toList());
	}

//	@Autowired
//	private UserRepository userRepository;
//
//	@GetMapping("/users")
//	public List<User> getUsers() {
//		return userRepository.findAll();
//	}
//	
//	@GetMapping("/user/{id}")
//	public Optional<User> getUser(@PathVariable Long id) {
//		return userRepository.findById(id);
//	}
//	
//	@DeleteMapping("/user/{id}")
//	public boolean deleteUser(@PathVariable Long id) {
//		userRepository.deleteById(id);
//		return true;
//	}
//	
//	@PutMapping("/userput")
//	public User updateUser(@RequestBody User user) {
//		return userRepository.save(user);
//	}
//
//	@PostMapping("/user")
//	public User createUser(@RequestBody User user) {
//		return userRepository.save(user);
//	}

}