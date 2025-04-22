package com.swapnil.Issue_Tracker.service;

import com.swapnil.Issue_Tracker.entity.Issue;
import com.swapnil.Issue_Tracker.repository.IssuesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuesService {

    private final IssuesRepo issuesRepo;

   public IssuesService(IssuesRepo issuesRepo){
        this.issuesRepo = issuesRepo;
    }

    public void addIssue(Issue issue) {
        issuesRepo.addIssue(issue);
    }

    public List<Issue> getAllIssues() {
        return issuesRepo.getAllIssues();
    }
}
