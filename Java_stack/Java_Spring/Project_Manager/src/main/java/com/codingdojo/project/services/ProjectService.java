package com.codingdojo.project.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.project.models.Project;
import com.codingdojo.project.models.User;
import com.codingdojo.project.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	private final ProjectRepository projectRepository;

	public ProjectService (ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
//Find project Operations
	List<Project> allProjects(Project project) {
		return projectRepository.findAll();
	}
	
	public Project findProject(Long id) {
		Optional<Project> thisProject =  projectRepository.findById(id);
		if (thisProject.isPresent()) {
			return thisProject.get();
		} else {
			return null;
		}
	}
	
	public List<Project> userProjects (User user) {
		List<Project> myProjects = projectRepository.findByJoinedUsersContains(user);
		return myProjects;
	}
	
	public List<Project> joinableProjects(User user) {
		List<Project> joinableProjects = projectRepository.findByJoinedUsersNotContains(user);
		return joinableProjects;
	}
	
	
//Create Update and Delete Operations	
	public Project createProject(Project project, BindingResult result) {
		Date currentDate = new Date();
		if (project.getDueDate() == null) {
			result.rejectValue("dueDate", "Exist", "Please enter a Date");
			return null;}
		if (project.getDueDate().after(currentDate)) {
			result.rejectValue("dueDate", "Compare", "Please enter a Date in the past ");
			return null;
		}
		else {
			return projectRepository.save(project);			
		}
	}
	
	public Project updateProject(Project project, BindingResult result) {
		Date currentDate = new Date();
		if (project.getDueDate() == null) {
			result.rejectValue("dueDate", "Exist", "Please enter a Date");
			return null;}
		if (project.getDueDate().after(currentDate)) {
			result.rejectValue("dueDate", "Compare", "Please enter a Date in the past ");
			return null;
		}
		else {		
			System.out.println(project.getId());
			Project thisProject = projectRepository.findById(project.getId()).orElse(null);
			assert thisProject != null;
			thisProject.setTitle(project.getTitle());
			thisProject.setDescription(project.getDescription());
			thisProject.setDueDate(project.getDueDate());
			return projectRepository.save(thisProject);
		}	
	 }
	
	public void Delete(Long id) {
		Project thisProject = projectRepository.findById(id).orElse(null);
		projectRepository.delete(thisProject);
	}

//Relating Users with Projects as either TeamLeaders or JoinTeams
	
	public Project joinTeam (User user, Project project) {
		project.getJoinedUsers().add(user);
		return projectRepository.save(project);
	}
	
	public Project leaveTeam (User user, Project project) {
		project.getJoinedUsers().removeIf(item -> item.getId().equals(user.getId()));
		return projectRepository.save(project);
	}
}
