package com.swapnil.Issue_Tracker.controller;

import com.swapnil.Issue_Tracker.entity.Project;
import com.swapnil.Issue_Tracker.model.ProjectResponse;
import com.swapnil.Issue_Tracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/string")
    private String returnString(){
        return "This is local hi";
    }

    @PostMapping("/add")
    private ProjectResponse addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @GetMapping
    private List<ProjectResponse> getAllProjects(){
        return projectService.getAllProjects();
    }

}
