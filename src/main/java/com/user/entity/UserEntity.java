package com.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="User")
public class UserEntity {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="account_status")
	private String accountStatus;
	@Column(name="email")
	private String email;
	@Column(name="phone_number")
	private String phno;
	@Column(name="dob")
	private Date dob;
	@Column(name="gender")
	private  String gender;
	@Column(name="country_name")
	private String countryName;
	@Column(name="country_id")
	private Integer countryId;
	@Column(name="state_name")
	private String stateName;
	@Column(name="state_id")
	private Integer stateId;
	@Column(name="city_name")
	private String cityName;
	@Column(name="city_id")
	private Integer cityId;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name="password")
	private String password;
	
	@Column(name="temporary_password")
	private String temporaryPassword;
	}
