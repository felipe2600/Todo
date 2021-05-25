package com.todoapp.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todoapp.todo.model.Todo;
import com.todoapp.todo.repository.TodoRepository;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

	@Autowired
	private TodoRepository repository;
	
	@GetMapping("{id}")
	public Todo getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo);
	}
}
