package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.dao.TaskDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.Project;
import com.example.demo.model.RoleName;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;

@RestController
public class TaskController
{
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private TaskDAO taskDAO;
	
	@GetMapping("tasksByStatus/{status}")
	public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable boolean status)
	{
		return taskService.FindByStatus(status);
	}
	@GetMapping("/tasks")
	public List<Task> get()
	{
		return taskDAO.findAll();
	}
	@GetMapping("tasksByUserId/{userId}")
	public ResponseEntity<List<Task>> getTaskByUser(@PathVariable int userId)
	{
		return taskService.FindByUserId(userId);
	}
	
	@GetMapping("tasksByProjectId/{projectId}")
	public ResponseEntity<List<Task>> getTaskByProject(@PathVariable int projectId)
	{
		return taskService.FindByProjectId(projectId);
	}
	
	@PostMapping("/tasks")
	public void createTask(@RequestBody Task task)
	{
		taskService.addTask(task);
	}
	@PutMapping("/tasks")
	public void updateTask(@RequestBody Task task)
	{
		taskService.updateTask(task);
	}
	@GetMapping("/tasksByUsername/{userName}")
	public ResponseEntity<List<Task>> getTaskByUserName(@PathVariable String userName)
	{
		return taskService.FindByUsername(userName);
	}
	@GetMapping("/tasksByProjectname/{projectName}")
	public ResponseEntity<List<Task>> getTaskByProjectName(@PathVariable String projectName)
	{
		return taskService.FindByProjectName(projectName);
	}
	
	//Just to add some data (no need)
	@PostMapping("/user")
	public void addUser(@RequestBody User user)
	{
		userDAO.save(user);
	}
	@PostMapping("/project")
	public void addPorject(@RequestBody Project project)
	{
		projectDAO.save(project);
	}
	@GetMapping("/user/role/{name}")
	public List<User> getAllByRole(@PathVariable RoleName name)
	{
		List<User> l = new ArrayList<>();
		for(User u:userDAO.findByRolesName(name))
		{
			l.add(u);
		}
		return l;
	}
}
