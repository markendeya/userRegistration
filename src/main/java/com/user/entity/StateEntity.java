package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="State")
@Data
public class StateEntity {
	@Column(name="state_name")
	private String stateName;
	@Id	
	@Column(name="state_Id")
	private Integer stateId;
	@Column(name="country_id")
	private Integer countryId;	

}
