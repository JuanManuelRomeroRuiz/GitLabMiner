package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Issue;
import aiss.PIntegracion.model.Project;
import aiss.PIntegracion.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IssueService {

    @Value("${gitlab.token}")
    private String token;

    @Value("${gitlab.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Issue> getAllIssuesFromProject(Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/issues";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Issue>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Issue>>() {}
        );
        return response.getBody();
    }

    public Issue getIssueByIdFromProject(Integer issueIid, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/issues/" + issueIid;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Issue> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Issue.class
        );
        return response.getBody();
    }

    public Issue createIssue(Issue issue, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/issues";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Issue> request = new HttpEntity<>(issue, headers);

        ResponseEntity<Issue> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                Issue.class
        );
        return response.getBody();
    }
}
