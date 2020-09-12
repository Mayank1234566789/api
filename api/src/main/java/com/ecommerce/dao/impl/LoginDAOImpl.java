package com.ecommerce.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.User;
import com.ecommerce.dao.LoginDAO;

public class LoginDAOImpl implements LoginDAO {
	

@PersistenceContext
private EntityManager entityManager;

	public String getLoginMessageByUserDetails(String username, String password) {
		  StoredProcedureQuery query = entityManager.createStoredProcedureQuery("e_commerce.sp_validate_user"); 
	        //Declare the parameters in the same order
	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

	        //Pass the parameter values
	        query.setParameter(1, username);
	        query.setParameter(2, password);
	       
	        //Execute query
	        List<Object[]> resultList =query.getResultList();
	       
	        Object result[] = resultList.get(0);
	        String resultMessage = String.valueOf(result[0]);
	        String resultCode = String.valueOf(result[1]);
		return resultCode;
	}

	public String saveUserDetails(String firstName,String lastName,String email, String password) {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("e_commerce.sp_sign_up_user"); 
	        //Declare the parameters in the same order
	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

	        //Pass the parameter values
	        query.setParameter(1, firstName);
	        query.setParameter(2, lastName);
	        query.setParameter(3, email);
	        query.setParameter(4, password);
	       
	        //Execute query
	        List<Object[]> resultList =query.getResultList();
	       
	        Object result[] = resultList.get(0);
	        String resultMessage = String.valueOf(result[0]);
	        String resultCode = String.valueOf(result[1]);
		return resultCode;
		
		
	}

	
}
