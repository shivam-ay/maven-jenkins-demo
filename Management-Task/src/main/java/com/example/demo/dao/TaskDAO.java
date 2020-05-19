package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Task;

@Repository(value = "taskDAO")
public interface TaskDAO extends JpaRepository<Task,Integer>
{
	@Query
//	public Iterable<Task> findByUserId(int userId);
//	public Iterable<Task> findByProjectId(int projectId);
	public Iterable<Task> findByStatus(boolean status);
}
