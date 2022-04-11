package com.codingdojo.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.project.models.Project;
import com.codingdojo.project.models.Task;
import com.codingdojo.project.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> projectTasks(Project project) {
		return taskRepository.findByTaskProject(project);
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	
}
