package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository(value = "userDAO")
public interface UserDAO extends JpaRepository<User,Integer>
{
	
}
