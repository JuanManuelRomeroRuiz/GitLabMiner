package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProjectService {

    @Value("${gitlab.token}")
    private String token;

    @Value("${gitlab.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Project> getAllProjects() {
        String url = apiUrl + "/projects";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Project>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Project>>() {}
        );
        return response.getBody();
    }

    public Project getProjectById(Integer id) {
        String url = apiUrl + "/projects/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Project> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Project.class
        );
        return response.getBody();
    }

    public Project createProject(Project project) {
        String url = apiUrl + "/projects";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Project> request = new HttpEntity<>(project, headers);

        ResponseEntity<Project> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                Project.class
        );
        return response.getBody();
    }
}
