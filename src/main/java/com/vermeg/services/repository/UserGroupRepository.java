package com.vermeg.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.services.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long>{

}
