package com.swapnil.Issue_Tracker.controller;

import com.swapnil.Issue_Tracker.entity.Issue;
import com.swapnil.Issue_Tracker.service.IssuesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issues")
public class IssuesController {

    private final IssuesService issuesService;
    private IssuesController(IssuesService issuesService){
        this.issuesService = issuesService;
    }

    @PostMapping
    public String addIssue(@RequestBody Issue issue){
        issuesService.addIssue(issue);
        return "Issue added successfully";
    }

}
