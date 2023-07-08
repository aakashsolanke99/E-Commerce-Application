package com.aakash.entity;

import java.util.Set;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
public class User {
	
	@Id
	private String userName;
	
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE",
	  joinColumns = {
           @JoinColumn(name="USER_ID")
	},
	  inverseJoinColumns = {
			  @JoinColumn(name="USER_ROLE")
	  }
	               )
	private Set<Role> roles;

	public User(String userName, String userFirstName, String userLastName, String userPassword, Set<Role> roles) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.roles = roles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userPassword=" + userPassword + ", roles=" + roles + "]";
	}
	
	

}
