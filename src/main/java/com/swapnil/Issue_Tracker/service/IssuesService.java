package com.swapnil.Issue_Tracker.service;

import com.swapnil.Issue_Tracker.entity.Issue;
import com.swapnil.Issue_Tracker.repository.IssuesRepo;
import org.springframework.stereotype.Service;

@Service
public class IssuesService {

    private final IssuesRepo issuesRepo;

    IssuesService(IssuesRepo issuesRepo){
        this.issuesRepo = issuesRepo;
    }

    public void addIssue(Issue issue) {
        issuesRepo.addIssue(issue);
    }
}
