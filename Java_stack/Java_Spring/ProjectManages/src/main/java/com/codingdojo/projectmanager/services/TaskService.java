package com.codingdojo.projectmanager.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.Task;
import com.codingdojo.projectmanager.repositories.TaskRepository;


@Service
public class TaskService {
    private final TaskRepository taskReposiyory;

    public TaskService(TaskRepository taskReposiyory) {
        this.taskReposiyory = taskReposiyory;
    }

    public List<Task> taskProject(Project project){

        Optional<List<Task>> tasks = taskReposiyory.findByProject(project);
        System.out.println(project.getId());
        if(tasks.isPresent()) {
            return tasks.get();
        }else {
            return null;
        }

    }

    public Task createTask(Task task) {
            return taskReposiyory.save(task);
        }


}