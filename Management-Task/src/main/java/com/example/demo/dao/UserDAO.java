package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RoleName;
import com.example.demo.model.User;

@Repository(value = "userDAO")
public interface UserDAO extends JpaRepository<User,Integer>
{
	@Query
	public List<User> findByRolesName(RoleName name);
}
