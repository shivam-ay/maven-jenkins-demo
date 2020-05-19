package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
public class TaskController
{
	@Autowired
	public TaskService taskService;
	
	@GetMapping("taskByStatus/{status}")
	public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable boolean status)
	{
		return taskService.FindByStatus(status);
	}
	
	@GetMapping("taskByUserId/{userId}")
	public ResponseEntity<List<Task>> getTaskByUser(@PathVariable int userId)
	{
		return taskService.FindByUserId(userId);
	}
	
	@GetMapping("taskByProjectId/{projectId}")
	public ResponseEntity<List<Task>> getTaskByProject(@PathVariable int projectId)
	{
		return taskService.FindByProjectId(projectId);
	}
	
	@PostMapping("/tasks")
	public void createTask(@RequestBody Task task)
	{
		taskService.addTask(task);
	}
	@PutMapping("/task")
	public void updateTask(@RequestBody Task task)
	{
		taskService.updateTask(task);
	}
	
}
