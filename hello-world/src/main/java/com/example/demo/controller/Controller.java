package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class Controller 
{
	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return("Hello-World");
	}
	@GetMapping("get")
	public String get(@PathVariable String name)
	{
		return(name);
	}
}
