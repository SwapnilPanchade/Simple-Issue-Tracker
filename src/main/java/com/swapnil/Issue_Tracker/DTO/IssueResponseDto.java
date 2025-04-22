package com.swapnil.Issue_Tracker.DTO;

import com.swapnil.Issue_Tracker.entity.IssueStatus;
import com.swapnil.Issue_Tracker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IssueResponseDto {
    private long id;
    private String title;
    private IssueStatus status;
    private Project project;
}
