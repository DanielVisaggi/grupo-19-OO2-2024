package com.unla.grupo19.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo19.entities.User;
import com.unla.grupo19.entities.UserRole;
import com.unla.grupo19.utils.Roles;


@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Serializable> {
	
	Optional<UserRole> findByRole(Roles rol);
}