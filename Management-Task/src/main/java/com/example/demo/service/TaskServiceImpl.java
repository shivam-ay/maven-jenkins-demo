package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.TaskDAO;
import com.example.demo.model.RoleName;
import com.example.demo.model.Task;
import com.example.demo.model.User;

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
		for(Task t:taskDAO.findByUserId(userId))
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
		Task task1 = taskDAO.findById(task.getId()).get();
		task1.setName(task.getName());
		task1.setStatus(task.isStatus());
		task1.setUser(task.getUser());
		task1.setTaskDesc(task.getTaskDesc());
		taskDAO.save(task1);
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
		for(Task t:taskDAO.findByUserUsernameStartingWith(userName))
		{
			task.add(t);
		}
		return ResponseEntity.ok().body(task);
	}

}
