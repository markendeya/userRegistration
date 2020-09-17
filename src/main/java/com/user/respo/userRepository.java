package com.user.respo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.entity.UserEntity;
import com.user.model.User;

@Repository
public interface userRepository extends JpaRepository<UserEntity,Serializable> {

	
	public UserEntity findByEmail(String email);
	
	
	public UserEntity findByTemporaryPassword(String temporaryPassword); 
	
	public UserEntity findByPasswordAndEmail(String password, String email);
	
	public UserEntity findByPassword(String password);
}
