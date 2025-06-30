package aiss.PIntegracion.controller;

import aiss.PIntegracion.model.Comment.Comment;
import aiss.PIntegracion.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gitlab/projects/{projectId}/issues/{issueId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@PathVariable Integer issueId,
                                        @PathVariable Integer projectId) {
        return commentService.getAllCommentsFromIssueFromProject(issueId, projectId);
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable String commentId,
                              @PathVariable Integer issueId,
                              @PathVariable Integer projectId) {
        return commentService.getCommentByIdFromIssueFromProject(commentId, issueId, projectId);
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment,
                                 @PathVariable Integer issueId,
                                 @PathVariable Integer projectId) {
        return commentService.createComment(comment, issueId, projectId);
    }
}
