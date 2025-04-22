package com.swapnil.Issue_Tracker.controller;

import com.swapnil.Issue_Tracker.DTO.IssueResponseDto;
import com.swapnil.Issue_Tracker.entity.Issue;
import com.swapnil.Issue_Tracker.service.IssuesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssuesController {

    private final IssuesService issuesService;
    public IssuesController(IssuesService issuesService){
        this.issuesService = issuesService;
    }

    @PostMapping
    public String addIssue(@RequestBody Issue issue){
        issuesService.addIssue(issue);
        return "Issue added successfully";
    }

    @GetMapping()
    public List<Issue> getAllIssue(){
        return issuesService.getAllIssues();
    }

    @GetMapping("/{id}")
    public List<IssueResponseDto> getIssueWithProject(@PathVariable long id){
        return issuesService.getIssueWithProject(id);
    }

    @GetMapping("/{id}")
    public IssueResponseDto getIssueWithId(@PathVariable long id ){
        return issuesService.getIssueWithId(id);
    }
}
