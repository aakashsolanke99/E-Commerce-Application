package com.aakash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aakash.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String>{

}
