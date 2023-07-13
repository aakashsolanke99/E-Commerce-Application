package com.aakash.configuartion;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aakash.service.JwtService;
import com.aakash.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
	final String header=	request.getHeader("Authorization");
	 
	String jwtToken =null;
	String userName=null;
	if(header!=null && header.startsWith("Bearer ")) {
		header.substring(7);
		
		try {
			userName=jwtUtil.getUserNameFromToken(jwtToken);
			
		}catch(IllegalArgumentException e) {
			System.out.println("Unable to get Jwt token");
		}catch(ExpiredJwtException e) {
			System.out.println("Jwt token is expired");
		}
	}
	else {
		System.out.println("jWT Token does not start with bearer");
	}
	
	if(userName!= null && SecurityContextHolder.getContext().getAuthentication()==null) {
		
		UserDetails userDetails=jwtService.loadUserByUsername(userName);
		
		if(jwtUtil.validateToken(jwtToken, userDetails)) {
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= 
					new UsernamePasswordAuthenticationToken(userDetails,
							null,
							userDetails.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}
	
	filterChain.doFilter(request, response);
	
	}

}
