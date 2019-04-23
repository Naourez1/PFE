package com.vermeg.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.services.model.UserGroup;
import com.vermeg.services.repository.UserGroupRepository;

@Service
public class UserGroupService {

	@Autowired
	private UserGroupRepository userGroupRepository;
	
	public UserGroup create(UserGroup userGroup) {
		return userGroupRepository.save(userGroup);
	}
	
	public UserGroup read(Long id) {
		return userGroupRepository.getOne(id);
	}
	
	public UserGroup update(UserGroup userGroup) {
		return this.create(userGroup);
	}
	
	public void delete(Long id) {
		userGroupRepository.deleteById(id);
	}
	
	public List<UserGroup> getAll(){
		return userGroupRepository.findAll();
	}
}
