package com.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	

	private Integer userId;

	private String firstName;
	private String lastName;
    private String accountStatus;
	private String email;

	private String phno;

	private Date dob;
	private  String gender;

	private String countryName;

	private Integer countryId;

	private String stateName;

	private Integer stateId;

	private String cityName;

	private Integer cityId;
	
	private Date createDate;
	
	private Date updateDate;
	
	private String password;
	private String temporaryPassword;

}
