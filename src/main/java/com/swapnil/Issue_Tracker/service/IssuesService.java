package com.swapnil.Issue_Tracker.service;

import com.swapnil.Issue_Tracker.DTO.IssueResponseDto;
import com.swapnil.Issue_Tracker.entity.Issue;
import com.swapnil.Issue_Tracker.repository.IssuesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuesService {

    private final IssuesRepo issuesRepo;
    private final IssueResponseDto issueResponseDto;

    public IssuesService(IssuesRepo issuesRepo, IssueResponseDto issueResponseDto) {
        this.issuesRepo = issuesRepo;
        this.issueResponseDto = issueResponseDto;
    }

    public void addIssue(Issue issue) {
        issuesRepo.addIssue(issue);
    }

    public List<Issue> getAllIssues() {
        return issuesRepo.getAllIssues();
    }

    public List<IssueResponseDto> getIssueWithProject(long id) {
        List<Issue> issues = issuesRepo.getIssueWithProject(id);
        return issues.stream().map(this :: issueMapper).toList();
    }


    //! to continue
    public IssueResponseDto issueMapper(Issue issue) {
        IssueResponseDto res = new IssueResponseDto();
        res.setId(issue.getId());
        res.setStatus(issue.getIssues());
        res.setProject(issue.getProject());
        res.setTitle(issue.getTitle());
        return res;
    }

    public IssueResponseDto getIssueWithId(long id) {
        Issue issue = issuesRepo.getIssueWIthId(id);
        return issueMapper(issue);
    }
}
