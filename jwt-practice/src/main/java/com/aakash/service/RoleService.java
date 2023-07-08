package com.aakash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aakash.dao.RoleDao;
import com.aakash.entity.Role;

@Service 
public class RoleService {
	
	@Autowired
	private RoleDao roledao;
	
	public Role createNewRole(Role role) {
		System.out.println("dfghjkjhgfdfghj");
		return roledao.save(role);
		
	}

}
