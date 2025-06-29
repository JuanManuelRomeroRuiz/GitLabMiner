package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommitService {

    @Value("${gitlab.token}")
    private String token;

    @Value("${gitlab.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Commit> getCommitsFromProject(Integer projectId) {
        String url = apiUrl + "/projects/" + projectId +  "/repository/commits";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Commit>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Commit>>() {}
        );
        return response.getBody();
    }

    public Commit getCommitByIdFromProject(String commitId, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/repository/commits/" + commitId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Commit> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Commit.class
        );
        return response.getBody();
    }

    public Commit createCommit(Commit commit, Integer projectId) {
        String url = apiUrl + "/projects/" + projectId + "/repository/commits";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Commit> request = new HttpEntity<>(commit, headers);

        ResponseEntity<Commit> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                Commit.class
        );
        return response.getBody();
    }
}
