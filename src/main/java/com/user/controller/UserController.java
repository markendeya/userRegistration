package com.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.model.Login;
import com.user.model.UnlockAccount;
import com.user.model.User;
import com.user.service.ServiceImpl;


@Controller
public class UserController {

	  @Autowired
	  public ServiceImpl service;
	  int count=123;
	  @RequestMapping(value="/loadForm")
	public String loadForm( Model themodel) {
		User user=new User();
		themodel.addAttribute("user", user);
		Map<Integer, String> countries = service.getCountries();
		themodel.addAttribute("countryMap",countries);
		return "userRegisteration";
	}
	  @RequestMapping(value="/state")
	  @ResponseBody
	  public Map<Integer, String> state(@RequestParam("id") Integer Id) {
		  Map<Integer, String>  states = service.getStates(Id);
		  return states;
	  }
	  
	  @RequestMapping(value="/city")
	  @ResponseBody
	  public Map<Integer, String> city(@RequestParam("id") Integer Id) {
		  Map<Integer, String>  cities = service.getCities(Id);
		  return cities;
	  }
	  
	  @RequestMapping(value="/saveUser")
	  public String saveUser(@ModelAttribute("user") User user,Model theModel) {
		  user.setTemporaryPassword(service.getAlphaNumericString(6));
		  Integer id=service.saveUser(user);
		  System.out.println(id+"id");
		  User userDetails = service.getUserById(id);
		  System.out.println(userDetails.getFirstName()+" test");
		  System.out.println(userDetails.getTemporaryPassword()+"  PASS");
		  theModel.addAttribute("msg", "saved successfully");
		  theModel.addAttribute("user", userDetails);
		  return "email";
	  }
	  @RequestMapping(value="/emailCheck")
	  @ResponseBody
	  public boolean emailCheck(@RequestParam("email") String s) {
		  List<User> users = service.getUsers();
		  boolean isEmailExist=false;
		  for(User u:users) {
			  if(u.getEmail()!=null) {
			  if(u.getEmail().equals(s)) {
				  System.out.println(s);
				  isEmailExist=true;
			  }
			  }
		  }
		  return isEmailExist;
	  }
	  
	  @RequestMapping("/unlockAcc")
	  public String unlockAcc(Model theModel,@RequestParam("email") String email) {
		  
		  UnlockAccount acc=new UnlockAccount();
		  acc.setEmail(email);
		  theModel.addAttribute("unlockAcc", acc);
		  
		  
		  return "unLockAcc";
	  }
	  @RequestMapping("/unlockAccount")
	  public String unlockAccount(Model theModel,@ModelAttribute("unlockAcc") UnlockAccount ucc) {
User userByEmail = service.findByTemporaryPassword(ucc.getTempPwd());
System.out.println(userByEmail);
userByEmail.setAccountStatus("unlocked");
userByEmail.setPassword(ucc.getNewPwd());
userByEmail.setUserId(userByEmail.getUserId());
	Integer saveUser = service.saveUser(userByEmail);
		  
		  System.out.println(saveUser);
		  return "unLockAccount";
	  }
	  
	  @RequestMapping("/login")
	  public String loginPage(Model theModel) {
		  Login g=new Login();
		  theModel.addAttribute("login", g);
		  return "login";
	  }
	  
	  @RequestMapping("/validateLogin")
	  public String validateLogin(@ModelAttribute("login") Login g,Model theModel) {
		  String email= g.getUserName();
		  String password=g.getPassword();
      boolean findByPasswordAndEmail = service.findByPasswordAndEmail(password,email);
       boolean userByPassword = service.getUserByPassword(password);
       boolean userByEmail = service.getUserByEmail(email);
       if(findByPasswordAndEmail) {
    	   theModel.addAttribute("msg", "Login Success");
		  return "loginSuccess";
       }
       if(userByEmail) {
    	   if(!userByPassword) {
    		   theModel.addAttribute("errorMsg", "Invalid password");
    	   }
       }else {
    	   theModel.addAttribute("errorMsg", "no user registered with that email");
       }
       return "error";
       
	  }
}
