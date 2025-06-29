package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Comment.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("Get all comments from Issue from Project")
    void getAllCommentsFromIssueFromProject() {
        List<Comment> comments = commentService.getAllCommentsFromIssueFromProject(1, 278964);
        assertNotNull(comments);
        System.out.println(comments);
    }

    @Test
    @DisplayName("Get Comment by ID from Issue from Project")
    void getCommentByIdFromIssueFromProject() {
        Comment comment = commentService.getCommentByIdFromIssueFromProject("4427023e1386417e4becf2fad2bd4ad459837e32", 1, 278964);
        assertNotNull(comment);
        System.out.println(comment);
    }
}