package aiss.PIntegracion.service;

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
public class UserService {

    @Value("${gitlab.token}")
    private String token;

    @Value("${gitlab.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getAllUsers() {
        String url = apiUrl + "/users";

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<User>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<User>>() {}
        );
        return response.getBody();
    }

    public User getUserById(Integer id) {
        String url = apiUrl + "/users/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<User> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                User.class
        );
        return response.getBody();
    }

    public User createUser(User user) {
        String url = apiUrl + "/users";
        HttpHeaders headers = new HttpHeaders();
        headers.set("PRIVATE-TOKEN", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<User> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                User.class
        );
        return response.getBody();
    }
}
