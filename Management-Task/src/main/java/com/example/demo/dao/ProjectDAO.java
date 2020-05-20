package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;

@Repository(value = "projectDAO")
public interface ProjectDAO extends JpaRepository<Project,Integer>
{

}
