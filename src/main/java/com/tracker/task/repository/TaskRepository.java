package com.tracker.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.task.entity.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
	
	public Task findByTitle(String title);

}
