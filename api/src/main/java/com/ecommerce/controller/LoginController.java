package com.ecommerce.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.User;
import com.ecommerce.dao.LoginDAO;
import com.ecommerce.exception.EcommerceException;
import com.ecommerce.repository.UserLoginRepository;

@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {
	
	@Autowired	
	private UserLoginRepository userLoginRepository;
	
	@Autowired
	private LoginDAO loginDAO;


	 @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userLoginRepository.findAll();
	    }

	  @PostMapping("/user")
	    public String getUserById(@RequestBody Map<String,String> body) throws EcommerceException {
		  String username = body.get("email").toString();
		  String password = body.get("password").toString();
		 String resultCode= loginDAO.getLoginMessageByUserDetails(username,password);
	        return resultCode;
	    }
	  
	  @PostMapping("/createuser")
	    public String checkUserDetails(@RequestBody Map<String,String> body) throws EcommerceException {
		  String firstName=body.get("firtname").toString();
		  String lastName=body.get("lastname").toString();
		  String email = body.get("email").toString();
		  String password = body.get("password").toString();
		 String resultCode= loginDAO.saveUserDetails(firstName,lastName,email,password);
	        return resultCode;
	    }


	
}
