package com.unla.grupo19.services;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo19.entities.User;


public interface IUserService  {
	
	public User saveOrUpdate(User user);
	
	public User findByUsernameQuery(String username);

	public boolean isAdmin(User user);
}
