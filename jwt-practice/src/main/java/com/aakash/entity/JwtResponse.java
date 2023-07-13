package com.aakash.entity;

public class JwtResponse {
	
	private User user;
	private String jwtToken;
	public JwtResponse(User user, String jwtToken) {
		super();
		this.user = user;
		this.jwtToken = jwtToken;
	}
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	@Override
	public String toString() {
		return "JwtResponse [user=" + user + ", jwtToken=" + jwtToken + "]";
	}
	
	

}
