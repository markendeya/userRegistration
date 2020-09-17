package com.user.respo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity,Serializable> {
	
	public List<StateEntity> findAllByCountryId(Integer Id);

}
