package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.UserRole;
import com.unla.grupo19.utils.Roles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unla.grupo19.entities.User;
import com.unla.grupo19.repositories.IUserRepository;
import com.unla.grupo19.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User saveOrUpdate(User user)throws Exception {
		if(Optional.ofNullable(user).isEmpty()) {
			throw new Exception();
		}
		return userRepository.save(user);
	}

	public User findByUsernameQuery(String username) {
		return userRepository.findByUsernameQuery(username);
	}

	@Override
	public boolean isAdmin(User user) {
		boolean isAdmin = false;
		for(UserRole userRol : user.getRoles()){
			if(userRol.getRole() == Roles.ROLE_ADMIN)
				isAdmin = true;
		}
		return isAdmin;
	}
}