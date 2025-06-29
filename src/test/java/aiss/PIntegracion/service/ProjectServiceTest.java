package aiss.PIntegracion.service;

import aiss.PIntegracion.model.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Test
    @DisplayName("Get all projects")
    void getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        assertFalse(projects.isEmpty());
        System.out.println(projects);
    }

    @Test
    @DisplayName("Get project by ID")
    void getProjectById() {
        Project project = projectService.getProjectById(71220048);
        assertNotNull(project);
        System.out.println(project);
    }
}