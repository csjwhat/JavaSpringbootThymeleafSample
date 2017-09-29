package com.example.hajibootthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hajibootthymeleaf.domain.User;
import com.example.hajibootthymeleaf.repository.UserRepository;

@Service
public class LoguinUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		if(user == null) {
			throw new UsernameNotFoundException("The requested user is not foud.");
		}
		return new LoginUserDetails(user);
	}
}
