package com.tracker.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.task.entity.Task;
import com.tracker.task.services.TaskServices;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskServices taskServices;

	// Create and Save Task;
	@PostMapping("/create")
	public ResponseEntity<Task> createAndSaveTask(@RequestBody Task task) {
		return new ResponseEntity<>(taskServices.createAndSaveTask(task),HttpStatus.CREATED);
	}

	// FindAll Task
	@GetMapping("/findAll")
	public List<Task> findAllTask() {
		return taskServices.findAllTask();
	}

	// FindById Task
	@GetMapping("/findbyId/{id}")
	public Task findById(@PathVariable Long id) throws Exception {

		return taskServices.findById(id);

	}

	// FindByTitle Task
	@GetMapping("/findbytitle/{title}")
	public Task findByTitle(@PathVariable String title) {
		return taskServices.findByTitle(title);
	}

	// Update Task
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) throws Exception {
		return new ResponseEntity<Task>(taskServices.updateTask(id, task), HttpStatus.CREATED);
	}

}
