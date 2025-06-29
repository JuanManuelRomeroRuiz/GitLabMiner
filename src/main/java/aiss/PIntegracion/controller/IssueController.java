package aiss.PIntegracion.controller;

import aiss.PIntegracion.model.Issue;
import aiss.PIntegracion.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gitlab/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/project/{projectId}")
    public List<Issue> getAllIssuesByProjectId(@PathVariable Integer projectId) {
        return issueService.getAllIssuesFromProject(projectId);
    }

    @GetMapping("/project/{projectId}/issue/{issueId}")
    public Issue getIssueById(@PathVariable Integer projectId, @PathVariable Integer issueId) {
        return issueService.getIssueByIdFromProject(issueId, projectId);
    }

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue, Integer projectId) {
        return issueService.createIssue(issue, projectId);
    }
}
