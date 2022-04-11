package com.codingdojo.project.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.project.models.Project;
import com.codingdojo.project.models.Task;
import com.codingdojo.project.models.User;
import com.codingdojo.project.services.ProjectService;
import com.codingdojo.project.services.TaskService;

@Controller
public class ProjectController {
	private final ProjectService projectService;
	private final TaskService taskService;

	public ProjectController(ProjectService projectService, TaskService taskService) {
		this.projectService = projectService;
		this.taskService = taskService;

	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			model.addAttribute("user", session.getAttribute("user"));
			List<Project> joinableProjects = projectService.joinableProjects(thisUser);
			model.addAttribute("joinableProjects", joinableProjects);
			List<Project> myProjects = projectService.userProjects(thisUser);
			model.addAttribute("myProjects", myProjects);
			return "Dashboard.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			return "ProjectForm.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/projects/new")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Project newProject = projectService.createProject(project, result);
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user"));
				return "ProjectForm.jsp";
			}else {
				return "redirect:/projects/" + newProject.getId() + "/relate";
			}
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/projects/{projectId}/relate")
	public String joinProject (@PathVariable ("projectId") Long id, HttpSession session) {
		if (session.getAttribute("user") != null) {
			Project thisProject = projectService.findProject(id);
			User thisUser = (User) session.getAttribute("user");
			projectService.joinTeam(thisUser, thisProject);
			return "redirect:/dashboard";
		}else {
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/projects/{projectId}/leave")
	public String leaveProject (@PathVariable ("projectId") Long id, HttpSession session) {
		if (session.getAttribute("user") != null) {
			Project thisProject = projectService.findProject(id);
			User thisUser = (User) session.getAttribute("user");
			projectService.leaveTeam(thisUser, thisProject);
			return "redirect:/dashboard";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/projects/{projectId}/edit")
	public String edtiProject(@PathVariable("projectId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Project thisProject = projectService.findProject(id);
			model.addAttribute("project", thisProject);
			return "ProjectEdit.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PutMapping("/projects/{projectId}/edit")
	public String updateProject(@PathVariable("projectId") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			projectService.updateProject(project, result);
			System.out.println(project.getTitle());
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user"));
				return "ProjectEdit.jsp";
			}else {
				return "redirect:/dashboard";
			}
		}else {
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/projects/{projectId}")
	public String showProject (@PathVariable("projectId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Project thisProject = projectService.findProject(id);
			List<User> teamMembers = thisProject.getJoinedUsers();
			model.addAttribute("project", thisProject);
			User thisUser = (User) session.getAttribute("user");
			if (teamMembers.stream().anyMatch(p -> p.getId().equals(thisUser.getId()))) {
				System.out.println("Hi");
				session.setAttribute("check", "exist");
			}
			else {
				session.setAttribute("check", "notexist");
			}
			return "ShowProject.jsp";
		}else {
			return "redirect:/";
		}
	}

//Task Specific controller
	
	@GetMapping("/projects/{projectId}/tasks")
	public String showTask(@PathVariable("projectId") Long id, @ModelAttribute("task") Task task, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Project thisProject = projectService.findProject(id);
			model.addAttribute("project", thisProject);
			List<Task> AllTasks = taskService.projectTasks(thisProject);
			model.addAttribute("tasks", AllTasks);
			return "TaskPage.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/projects/{projectId}/tasks")
	public String createTask(@PathVariable("projectId") Long id, @Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user"));
				Project thisProject = projectService.findProject(id);
				model.addAttribute("project", thisProject);
				List<Task> AllTasks = taskService.projectTasks(thisProject);
				model.addAttribute("tasks", AllTasks);
				return "TaskPage.jsp";
			}else {
				Task newTask = taskService.createTask(task);
				return "redirect:/projects/" + id + "/tasks";
			}
		}else {
			return "redirect:/";
		}
	}
	
	

}
