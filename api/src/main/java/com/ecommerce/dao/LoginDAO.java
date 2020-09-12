package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ecommerce.api.User;

@Repository
public interface LoginDAO {
	

	public String getLoginMessageByUserDetails(String username,String password);
	
	public String saveUserDetails(String firstName,String lastName,String email, String password);
	
		
	
}
