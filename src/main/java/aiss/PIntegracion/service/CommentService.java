package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {

    @Value("${gitlab.token}")
    private String token;

    @Value("${gitlab.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Comment> getAllCommentsFromIssueFromProject(Integer issueIid, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/issues/" + issueIid + "/discussions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<List<Comment>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Comment>>() {}
        );
        return response.getBody();
    }

    public Comment getCommentByIdFromIssueFromProject(String commentId,Integer issueIid, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/issues/" + issueIid + "/discussions/" + commentId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Comment> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Comment.class
        );
        return response.getBody();
    }

    public Comment createComment(Comment comment,Integer issueIid, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/issues/" + issueIid + "/comments";

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Comment> request = new HttpEntity<>(comment, headers);

        ResponseEntity<Comment> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                Comment.class
        );
        return response.getBody();
    }
}