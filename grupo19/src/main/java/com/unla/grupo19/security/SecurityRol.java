package com.unla.grupo19.security;

import org.springframework.security.core.GrantedAuthority;

import com.unla.grupo19.entities.UserRole;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityRol implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserRole userRole;

	@Override
	public String getAuthority() {
		return userRole.getRole().toString();
	}
	
	

}
