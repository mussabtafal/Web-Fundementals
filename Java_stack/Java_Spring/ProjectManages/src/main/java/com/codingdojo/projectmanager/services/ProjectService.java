package com.codingdojo.projectmanager.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.repositories.ProjectRepository;



@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository ;
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    
    public List<Project> allProjects(){
        return projectRepository.findAll();
    }
    
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
    public List<Project> findUserProject(User user){
        Optional <List<Project>> projects = projectRepository.findByTeamMembersContains(user);
        if(projects.isPresent()) {
            return projects.get();
        }else {
            return null;
        }
        
    }
    
    public Project createProject(Project project, BindingResult result) {
        Date currentDate = new Date();
        System.out.println(project.getDueDate());
        if (project.getDueDate()== null) {  
            result.rejectValue("dueDate", "empty", "DueDate is required!");
            return null;
        }
        else if (project.getDueDate().after(currentDate)) {
            result.rejectValue("dueDate", "new", "DueDate must be in the past!");
            return null;
        }
        else {
            return projectRepository.save(project);
        }
    }
    
    public Project addTeamMember(Project project, User teamMember) {
          project.getTeamMembers().add(teamMember);
          return projectRepository.save(project);
       }
    public Project removeTeamMember(Project project, User teamMember) {
        List <User> teamMembers = project.getTeamMembers();
        System.out.println(teamMembers.get(0));
        teamMembers.removeIf(item -> item.getId().equals(teamMember.getId()));
        return projectRepository.save(project);
     }
    
    public Project updateProject(Project project) {
        Project proj = projectRepository.findById(project.getId()).orElse(null);
        assert proj!=null;
        proj.setTitle(project.getTitle());
        proj.setDescription(project.getDescription());
        proj.setDueDate(project.getDueDate());
        return projectRepository.save(proj);
    }
    
    public List<Project> toJoinProject(User user){
        Optional <List<Project>> projects = projectRepository.findByTeamMembersNotContains(user);
        if(projects.isPresent()) {
            return projects.get();
        }else {
            return null;
        }
        
    }
    
    
    
    public void delete(Long id) {
        Project deleteProject = projectRepository.findById(id).orElse(null); 
        projectRepository.delete(deleteProject);
      }
}