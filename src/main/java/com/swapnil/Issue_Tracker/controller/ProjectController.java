package com.swapnil.Issue_Tracker.controller;

import com.swapnil.Issue_Tracker.entity.Project;
import com.swapnil.Issue_Tracker.DTO.ProjectResponseDto;
import com.swapnil.Issue_Tracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/string")
    public String returnString(){
        return "This is local hi";
    }

    @PostMapping("/add")
    public ProjectResponseDto addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @GetMapping
    public List<ProjectResponseDto> getAllProjects(){
        return projectService.getAllProjects();
    }
    //? get project by id
    @GetMapping("/{id}")
    public ProjectResponseDto getProjectById(@PathVariable long id){
        return projectService.getProjectById(id);
    }

    //PUT update the project by id
    @PutMapping("/{id}")
    public ProjectResponseDto updateProject(@RequestBody Project project, @PathVariable long id){
        return projectService.updateProject(project, id);
    }

}
