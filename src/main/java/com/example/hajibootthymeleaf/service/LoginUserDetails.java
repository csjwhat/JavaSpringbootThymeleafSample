package com.example.hajibootthymeleaf.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.hajibootthymeleaf.domain.User;

import lombok.Data;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 2389204124517610893L;
	private final User user;

	public LoginUserDetails(User user) {
		super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
}
