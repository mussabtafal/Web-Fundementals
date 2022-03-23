package com.codingdojo.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.Task;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.TaskService;


@Controller
public class TaskController {
    
    private final TaskService taskService;
    private final ProjectService projectService;
    


    public TaskController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }



    @GetMapping("/projects/{id}/tasks")
     public String showTasks(@PathVariable("id") Long id, Model model,HttpSession session,@ModelAttribute("task") Task task) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("user", session.getAttribute("user"));
            Project proj = projectService.findProject(id);
            model.addAttribute("project",proj);
            System.out.println(proj.getId());
            List<Task> allTask=taskService.taskProject(proj);
            model.addAttribute("allTask",allTask);
            return "tasks.jsp";
     }else {
         return "redirect:/";
     }    
    }
    
    @PostMapping("/projects/{id}/tasks")
    public String addNewBook (@PathVariable("id") Long id,@Valid @ModelAttribute("task") Task task, BindingResult result,Model model,HttpSession session) {
        if (session.getAttribute("user") != null) {
            if (result.hasErrors()) {    
                model.addAttribute("user", session.getAttribute("user"));
                Project proj = projectService.findProject(id);
                model.addAttribute("project",proj);
                System.out.println(proj.getId());
                List<Task> allTask=taskService.taskProject(proj);
                model.addAttribute("allTask",allTask);
                return "tasks.jsp";
            }else {
                Project proj = projectService.findProject(id);
                model.addAttribute("project",proj);
                model.addAttribute("user", session.getAttribute("user"));
                taskService.createTask(task);
                List<Task> allTask=taskService.taskProject(proj);
                model.addAttribute("allTask",allTask);
                return "redirect:/projects/"+id+"/tasks";
            }
        }
        else {
            return "redirect:/";
        }
        
    }
}