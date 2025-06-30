package aiss.PIntegracion.controller;

import aiss.PIntegracion.model.Commit;
import aiss.PIntegracion.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gitlab/projects/{projectId}/commits")
public class CommitController {

    @Autowired
    private CommitService commitService;

    @GetMapping
    public List<Commit> getAllCommitsFromProject(@PathVariable Integer projectId) {
        return commitService.getCommitsFromProject(projectId);
    }

    @GetMapping("/{commitId}")
    public Commit getCommitByIdFromProject(@PathVariable String commitId,
                                           @PathVariable Integer projectId) {
        return commitService.getCommitByIdFromProject(commitId, projectId);
    }

    @PostMapping
    public Commit createCommit(@RequestBody Commit commit,
                               @PathVariable Integer projectId) {
        return commitService.createCommit(commit, projectId);
    }
}
