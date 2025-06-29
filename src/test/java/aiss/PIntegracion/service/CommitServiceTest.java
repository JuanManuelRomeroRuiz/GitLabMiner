package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    private CommitService commitService;

    @Test
    @DisplayName("Get all commits from Project")
    void getCommitsFromProject() {
        List<Commit> commits = commitService.getCommitsFromProject(71205032);
        assertNotNull(commits);
        System.out.println(commits);
    }

    @Test
    @DisplayName("Get commit by ID from Project")
    void getCommitByIdFromProject() {
        Commit commit = commitService.getCommitByIdFromProject("1fc2f51ef57af6760ea79a3f16d61bc0117ccf3e", 71205032);
        assertNotNull(commit);
        System.out.println(commit);
    }
}