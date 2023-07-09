package com.aakash.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aakash.dao.RoleDao;
import com.aakash.dao.UserDao;
import com.aakash.entity.Role;
import com.aakash.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public User registerNewUser(User user) {
		return userDao.save(user);
		
	}

	public void initRoleAndUser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleDao.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default Role for newly created records");
		roleDao.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserFirstName("Aakash");
		adminUser.setUserLastName("Solanke");
		adminUser.setUserName("Admin123");
		adminUser.setUserPassword("Admin@123");
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRoles(adminRoles);
		userDao.save(adminUser);
		
		User user = new User();
		user.setUserFirstName("swaraj");
		user.setUserLastName("Solanke");
		user.setUserName("swaraj123");
		user.setUserPassword("swaraj@123");
		Set<Role> userRoles=new HashSet<>();
		userRoles.add(userRole);
	    user.setRoles(userRoles);
		userDao.save(user);
		}
}
