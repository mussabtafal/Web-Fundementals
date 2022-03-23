package com.codingdojo.projectmanager.controllers;

import java.util.ArrayList;
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

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.ProjectService;


@Controller
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}


	@GetMapping("/dashboard")
    public String home(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
        	model.addAttribute("user", session.getAttribute("user"));
        	User user = (User) session.getAttribute("user");
        	List<Project> allProject = projectService.toJoinProject(user);
        	List<Project> userProject = projectService.findUserProject(user);
        	model.addAttribute("userProjects", userProject);
            model.addAttribute("allProjects", allProject);
            return "dashboard.jsp";
        }
        else {
            return "redirect:/";
        }
    }
	
	
	
	@GetMapping("/projects/new")
	public String newProject (@ModelAttribute("project") Project project,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			return "newProject.jsp";
    	}else {
    		return "redirect:/";
    	}
    }
	
	@PostMapping("/projects/new")
	public String addNewBook (@Valid @ModelAttribute("project") Project project, BindingResult result,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			Project newProject = projectService.createProject(project, result);
			if (result.hasErrors()) {	
				System.out.println(project.getTeamMembers());
				model.addAttribute("user", session.getAttribute("user"));
				return "newProject.jsp";
			}else {
				User user = (User) session.getAttribute("user");
				List <User> members =new ArrayList<User>();
				newProject.setTeamMembers(members);
				projectService.addTeamMember(newProject, user);
				return "redirect:/dashboard";
			}
    	}
		else {
    		return "redirect:/";
    	}
		
	}
	
	
	@GetMapping("/projects/{projectId}/join")
	public String joinProject (@PathVariable ("projectId") Long id, Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			User user = (User) session.getAttribute("user");
			Project thisProject =projectService.findProject(id);
			projectService.addTeamMember(thisProject, user);
			return "redirect:/dashboard";
    	}else {
    		return "redirect:/";
    	}
    }
	
	@GetMapping("/projects/{projectId}/leave")
	public String leaveProject (@PathVariable ("projectId") Long id, Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			User user = (User) session.getAttribute("user");
			Project thisProject =projectService.findProject(id);
			projectService.removeTeamMember(thisProject, user);
			return "redirect:/dashboard";
    	}else {
    		return "redirect:/";
    	}
    }
	
	@GetMapping("/projects/{projectId}/edit")
	public String editBook (@PathVariable("projectId") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Project thisProject = projectService.findProject(id);
			model.addAttribute("projectt",thisProject);
			return "editProject.jsp";
    	}else {
    		return "redirect:/";
    	}
    }
	@PutMapping("/projects/{projectId}/edit")
	public String updateBook (@Valid @ModelAttribute("projectt") Project projectt, BindingResult result,@PathVariable("projectId") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {	
				model.addAttribute("user", session.getAttribute("user"));
				return "editProject.jsp";
			}else {
				Project oldProject = projectService.findProject(id);
				projectt.setId(oldProject.getId());
				projectService.updateProject(projectt);
				return "redirect:/dashboard";
			}
    	}
		else {
    		return "redirect:/";
    	}
    }
	
	@GetMapping("/projects/{id}")
	 public String show(@PathVariable("id") Long id, Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Project proj = projectService.findProject(id);
			model.addAttribute("project",proj);
			return "projectDetail.jsp";
   	}else {
   		return "redirect:/";
   	}	
	}
	
}
