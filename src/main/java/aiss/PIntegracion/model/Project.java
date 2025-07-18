package aiss.PIntegracion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @Column(name="title")
    @NotEmpty(message = "Project name is required")
    private String name;

    @JsonProperty("web_url")
    @Column(name = "webUrl")
    @NotEmpty(message = "Project url is required")
    private String webUrl;

    @JsonProperty("issue_id")
    @OneToMany
    private List<Issue> issue;

    @JsonProperty("commit_id")
    @OneToMany
    private List<Commit> commit;

    public Project(Integer id, String name, String webUrl, Integer issueId) {
        this.id = id;
        this.name = name;
        this.webUrl = webUrl;
        this.issue = new ArrayList<Issue>();
        this.commit = new ArrayList<Commit>();
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @JsonProperty
    public List<Issue> getIssueId() {
        return issue;
    }

    @JsonProperty
    public void setIssueId(List<Issue> issueId) {
        this.issue = issueId;
    }

    @JsonProperty
    public List<Commit> getCommitId() {
        return commit;
    }

    @JsonProperty
    public void setCommitId(List<Commit> commitId) {
        this.commit = commitId;
    }

    @Override
    public String toString() {
        return "Project{ " +
                "id = " + id +
                ", name = " + name +
                ", webUrl = " + webUrl +
//                ", issueId = " + issue +
//                ", commitId = " + commit +
                "} \n";
    }
}