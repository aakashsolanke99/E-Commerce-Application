package com.aakash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aakash.dao.UserDao;
import com.aakash.entity.JwtRequest;
import com.aakash.entity.JwtResponse;
import com.aakash.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) {
		String userName= jwtRequest.getUserName();
		String userPassword=jwtRequest.getUserPassword();
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	private void authenticate(String userName,String userPassword) {
		try {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		
	}catch (DisabledException e) {
		throw new Exception("")
	}
	}
}
