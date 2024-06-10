package com.unla.grupo19.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo19.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Serializable> {
	
	Optional<User> findByUsername(String username);
	
}
