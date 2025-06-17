package com.tracker.task.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String title;

	@Column(name = "task_details", length = 50)
	private String content;

	@Enumerated
	private TaskStatus taskStatus = TaskStatus.NotStarted;

	private LocalDateTime startDateTime = LocalDateTime.now();

	private LocalDateTime endDateTime = null;

}
