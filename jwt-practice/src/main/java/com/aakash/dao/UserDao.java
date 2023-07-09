package com.aakash.dao;

import org.springframework.data.repository.CrudRepository;

import com.aakash.entity.User;

public interface UserDao extends CrudRepository<User,String>{

}
