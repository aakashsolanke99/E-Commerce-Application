package com.aakash.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	private String userName;
	
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	
	@ManyToMany(fetch = FetchType.EAGER ,cascade = jakarta.persistence.CascadeType.ALL)
	@JoinTable(name = "USER_ROLE",
	  joinColumns = {
           @JoinColumn(name="USER_ID")
	},
	  inverseJoinColumns = {
			  @JoinColumn(name="USER_ROLE")
	  }
	               )
	private Set<Role> role;

	public User(String userName, String userFirstName, String userLastName, String userPassword, Set<Role> role) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.role = role;
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
		return role;
	}

	public void setRoles(Set<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userPassword=" + userPassword + ", roles=" + role + "]";
	}
	
	

}
