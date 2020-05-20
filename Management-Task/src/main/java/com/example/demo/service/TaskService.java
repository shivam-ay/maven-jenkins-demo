package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Task;

public interface TaskService
{
	public ResponseEntity<List<Task>> FindByStatus(boolean status);
	public ResponseEntity<List<Task>> FindByUserId(int userId);
	public ResponseEntity<List<Task>> FindByProjectId(int projectId);
	public ResponseEntity<List<Task>> FindByProjectName(String projectName);
	public ResponseEntity<List<Task>> FindByUsername(String userName);
	public void addTask(Task task);
	public void updateTask(Task task);
}
