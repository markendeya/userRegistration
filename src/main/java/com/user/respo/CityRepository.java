package com.user.respo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity,Serializable> {
	
	public List<CityEntity> findAllByStateId(Integer Id);

}
