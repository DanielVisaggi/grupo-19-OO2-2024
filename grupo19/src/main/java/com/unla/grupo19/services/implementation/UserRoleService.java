package com.unla.grupo19.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo19.entities.UserRole;
import com.unla.grupo19.repositories.IUserRoleRepository;
import com.unla.grupo19.services.IUserRoleService;
import com.unla.grupo19.utils.Roles;

@Service
public class UserRoleService implements IUserRoleService {

	@Autowired
	private IUserRoleRepository userRoleRepository;
	@Override
	public List<UserRole> listarRoles() {
		return userRoleRepository.findAll();
	}
	
	public Optional<UserRole> traerPorNombre(Roles rol){
		return userRoleRepository.findByRole(rol);
	}

}
