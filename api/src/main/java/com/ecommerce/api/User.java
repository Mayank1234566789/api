package com.ecommerce.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	 @Id
    @GeneratedValue
    @Column(name = "id")
	public Long id;
	 
	 @Column(name = "username")
  public String username;
	 
	 @Column(name = "password")
  public String password;
  
  public User(Long id,String username,String password) {
	    super();
	    this.id=id;
	    this.username = username;
	    this.password=password;
	   
	  }
  public User(){
      super();
  }
}
