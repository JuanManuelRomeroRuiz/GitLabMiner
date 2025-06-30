package aiss.PIntegracion.controller;

import aiss.PIntegracion.model.Issue;
import aiss.PIntegracion.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gitlab/projects/{projectId}/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping
    public List<Issue> getAllIssuesFromProject(@PathVariable Integer projectId) {
        return issueService.getAllIssuesFromProject(projectId);
    }

    @GetMapping("/{issueId}")
    public Issue getIssueById(@PathVariable Integer projectId,
                              @PathVariable Integer issueId) {
        return issueService.getIssueByIdFromProject(issueId, projectId);
    }

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue,
                             @PathVariable Integer projectId) {
        return issueService.createIssue(issue, projectId);
    }
}
