package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Country")
@Data
public class CountryEntity {
	@Column(name="country_name")
	private String countryName;
	@Id
	@Column(name="country_id")
	private Integer countryId;
	@Column(name="country_code")
	private String countryCode;

}
