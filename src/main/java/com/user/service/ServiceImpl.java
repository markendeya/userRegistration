package com.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.CityEntity;
import com.user.entity.CountryEntity;
import com.user.entity.StateEntity;
import com.user.entity.UserEntity;
import com.user.model.Country;
import com.user.model.User;
import com.user.respo.CityRepository;
import com.user.respo.CountryRepository;
import com.user.respo.StateRepository;
import com.user.respo.userRepository;

@Service
public class ServiceImpl implements IService {

	@Autowired
	private userRepository userRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;

	@Override
	public List<User> getUsers() {
		List<UserEntity> users = userRepo.findAll();
		List<User> userList=new ArrayList<User>();
		for(UserEntity user:users) {
			User u=new User();
			BeanUtils.copyProperties(user, u);
			userList.add(u);
		}
		
		return userList;
	}

	@Override
	public User getUserById(Integer id) {
		Optional<UserEntity> userEntity = userRepo.findById(id);
		User user =new User();
		BeanUtils.copyProperties(userEntity.get(), user);
		return user;
	}

	@Override
	public Integer saveUser(User user) {
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity userDetails = userRepo.save(userEntity);
		return userDetails.getUserId();
	}

	@Override
	public boolean updateUser(Integer Id, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, String> getCountries() {
		Map<Integer,String> countryMap=new HashMap<Integer,String>();
		List<CountryEntity> countryEntity = countryRepo.findAll();
	for(CountryEntity c  :countryEntity) {
		countryMap.put(c.getCountryId(), c.getCountryName());
	}
		return countryMap;
	}

	@Override
	public Country getCountryById(Integer Id) {
		return null;
	}

	@Override
	public Map<Integer, String> getStates(Integer Id) {
		List<StateEntity> findAllByCountryId = stateRepo.findAllByCountryId(Id);
		Map<Integer,String> stateMap=new HashMap<Integer,String>();
		for(StateEntity state:findAllByCountryId) {
			stateMap.put(state.getStateId(), state.getStateName());
		}
		return stateMap;
	}
	@Override
	public Map<Integer, String> getCities(Integer Id) {
		List<CityEntity> cityEnity = cityRepo.findAllByStateId(Id);
		Map<Integer,String> cityMap=new HashMap<Integer,String>();
		for(CityEntity city: cityEnity) {
			cityMap.put(city.getCityId(), city.getCityName());
		}
		return cityMap;
	}

	@Override
	public String getEmailById(Integer Id) {
		Optional<UserEntity> findById = userRepo.findById(Id);
		User user=new User();
		BeanUtils.copyProperties(findById.get(), user);
		return user.getEmail();
	}

	@Override //findByPassword
	public boolean getUserByEmail(String email) {
		UserEntity userEntity = userRepo.findByEmail(email);
		if(userEntity!=null) {
			return true;
		}
		return false;
	}
	public boolean getUserByPassword(String password) {
		UserEntity userEntity = userRepo.findByPassword(password);
		if(userEntity!=null) {
			return true;
		}
		return false;
	}
	public User findBytemporaryPassword(Integer id) {
	//	UserEntity userEntity = userRepo.findByTemporaryPassword(temp);
		return getUserById(id);
	}
	public User findByTemporaryPassword(String email) {
		UserEntity userEntity = userRepo.findByTemporaryPassword(email);
		User user=new User();
		if(userEntity!=null) {
			BeanUtils.copyProperties(userEntity, user);
		}
		return user;
	}
	public boolean findByPasswordAndEmail(String password, String email) {
		UserEntity userEntity = userRepo.findByPasswordAndEmail(password,email);
		if(userEntity!=null) {
			return true;
		}
		return false;
	}
	
	public String getAlphaNumericString(int n) 
	    { 
	  
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    }
}
