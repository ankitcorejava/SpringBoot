package com.tracker.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.task.entity.Task;
import com.tracker.task.repository.TaskRepository;

@Service
public class TaskServices {

	@Autowired
	private TaskRepository taskRepository;

	// Create and Save Task;
	public Task createAndSaveTask(Task task) {
		taskRepository.save(task);
		return task;
	}

	// FindAll Task

	public List<Task> findAllTask() {
		return taskRepository.findAll();
	}

	// FindById Task
	public Task findById(Long id) throws Exception {

		return taskRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));

	}

	// FindByTitle Task
	public Task findByTitle(String title) {

		return taskRepository.findByTitle(title);

	}

	// Update Task
	public Task updateTask(Long id, Task task) throws Exception {

		Task taskref = taskRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
		taskref.setContent(task.getContent());
		taskref.setTitle(task.getTitle());
		taskref.setStartDateTime(task.getStartDateTime().minusDays(3));
		return taskref;
	}

}
