package com.user.service;

import java.util.List;
import java.util.Map;

import com.user.entity.UserEntity;
import com.user.model.Country;
import com.user.model.User;

public interface IService {
	
	public List<User> getUsers();
	
	public User getUserById(Integer id);
	
	public Integer saveUser(User user);
	public boolean updateUser(Integer Id ,User user);
	
	public boolean deleteUser(Integer id);
	// country related methods
	
	public Map<Integer,String > getCountries();
	
	public Country getCountryById(Integer Id);
	
	public Map<Integer ,String> getStates(Integer Id);
	public Map<Integer ,String> getCities(Integer Id);
	
	public String getEmailById(Integer Id);
	public boolean getUserByEmail(String email);
	public User findBytemporaryPassword(Integer Id) ;
	public String getAlphaNumericString(int n);
	
    public User findByTemporaryPassword(String email);
    public boolean findByPasswordAndEmail(String password, String email);

}
