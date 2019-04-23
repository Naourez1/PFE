package com.vermeg.services.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vermeg.services.exception.CustomException;
import com.vermeg.services.model.Task;
import com.vermeg.services.model.User;
import com.vermeg.services.repository.UserRepository;
import com.vermeg.services.security.JwtTokenProvider;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	public String signin(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			Optional<User> opUser = userRepository.findByUsername(username);
			final User user = opUser.isPresent() ? opUser.get() : null;

			if (user == null) {
				throw new UsernameNotFoundException("User '" + username + "' not found");
			}
			return jwtTokenProvider.createToken(username, user.getRoles());
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public String signup(User user) {
		if (!userRepository.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
		} else {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User search(Long id) {
		Optional<User> opUser = userRepository.findById(id);
		final User user = opUser.isPresent() ? opUser.get() : null;

		if (user == null) {
			throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}

	public User whoami(HttpServletRequest req) {
		String username = jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req));
		Optional<User> opUser = userRepository.findByUsername(username);
		final User user = opUser.isPresent() ? opUser.get() : null;

		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found");
		}
		return user;
	}

	public String refresh(String username) {
		Optional<User> opUser = userRepository.findByUsername(username);
		final User user = opUser.isPresent() ? opUser.get() : null;

		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found");
		}
		return jwtTokenProvider.createToken(username, user.getRoles());
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public List<Task> getTasksOfUser(Long id) {
		return userRepository.findTasksOfUser(id).orElse(Collections.<Task>emptyList());
	}

}
