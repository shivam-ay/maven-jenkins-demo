package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDAO;
import com.example.demo.model.Task;

@Service(value = "taskService")
public class TaskServiceImpl implements TaskService
{
	@Autowired
	private TaskDAO taskDAO;
	@Override
	public ResponseEntity<List<Task>> FindByStatus(boolean status)
	{
		List<Task> task = new ArrayList<>();
		for(Task t:taskDAO.findByStatus(status))
		{
			task.add(t);
		}
		return ResponseEntity.ok().body(task);
	}

	@Override
	public ResponseEntity<List<Task>> FindByUserId(int userId)
	{
		List<Task> task = new ArrayList<>();
		for(Task t:taskDAO.findByUserUserId(userId))
		{
			task.add(t);
		}
		return ResponseEntity.ok().body(task);
	}

	@Override
	public ResponseEntity<List<Task>> FindByProjectId(int projectId) 
	{
		List<Task> task = new ArrayList<>();
		for(Task t:taskDAO.findByProjectProjectId(projectId))
		{
			task.add(t);
		}
		return ResponseEntity.ok().body(task);
	}

	@Override
	public void addTask(Task task)
	{
		taskDAO.save(task);
	}

	@Override
	public void updateTask(Task task) 
	{
		taskDAO.save(task);
	}

	@Override
	public ResponseEntity<List<Task>> FindByProjectName(String projectName)
	{
		List<Task> task = new ArrayList<>();
		for(Task t:taskDAO.findByProjectProjectNameStartingWith(projectName))
		{
			task.add(t);
		}
		return ResponseEntity.ok().body(task);
	}

	@Override
	public ResponseEntity<List<Task>> FindByUsername(String userName)
	{
		List<Task> task = new ArrayList<>();
		for(Task t:taskDAO.findByUserFirstNameStartingWith(userName))
		{
			task.add(t);
		}
		return ResponseEntity.ok().body(task);
	}

}
