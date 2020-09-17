package com.user.respo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity,Serializable> {

}
