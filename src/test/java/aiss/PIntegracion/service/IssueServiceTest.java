package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService issueService;

    @Test
    @DisplayName("Get all Issues from Project")
    void getAllIssuesByProjectId() {
        List<Issue> issues = issueService.getAllIssuesFromProject(278964);
        assertNotNull(issues);
        System.out.println(issues);
    }

    @Test
    @DisplayName("Get Issue by ID from Project")
    void getIssueByIdFromProject() {
        Issue issue = issueService.getIssueByIdFromProject(1, 278964);
        assertNotNull(issue);
        System.out.println(issue);
    }
}