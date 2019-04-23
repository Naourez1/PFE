package com.vermeg.services.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vermeg.services.model.Task;
import com.vermeg.services.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Transactional
	void deleteByUsername(String username);

	@Query("SELECT t FROM Task t JOIN User u WHERE u.id = ?1")
	Optional<List<Task>> findTasksOfUser(Long id);
}