package com.swapnil.Issue_Tracker.service;

import com.swapnil.Issue_Tracker.entity.Project;
import com.swapnil.Issue_Tracker.DTO.ProjectResponseDto;
import com.swapnil.Issue_Tracker.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    private ProjectResponseDto mapToResponse(Project project) {
        ProjectResponseDto response = new ProjectResponseDto();
        response.setId(project.getId());
        response.setName(project.getName());
        response.setDescription(project.getDescription());
        response.setCreatedAt(project.getCreatedAt());
        response.setUpdatedAt(project.getUpdatedAt());
        return response;
    }

    public ProjectResponseDto addProject(Project project) {
        Project p1 =  projectRepo.addProject(project);
        return mapToResponse(p1);
    }

    public List<ProjectResponseDto> getAllProjects() {
        return projectRepo.getAllProjects().stream().map(this::mapToResponse).toList();
    }

    public ProjectResponseDto getProjectById(long id) {
        Project p1 = projectRepo.getProjectById(id);
        return mapToResponse(p1);
    }

    public ProjectResponseDto updateProject(Project project, long id) {
        Project project1 = projectRepo.updateProject(project,id);
        return mapToResponse(project1);
    }

    public List<ProjectResponseDto> deleteProject(long id) {
        List<Project> projects = projectRepo.deleteProjectById(id);
        return projects.stream().map( this :: mapToResponse).toList();
    }
}
