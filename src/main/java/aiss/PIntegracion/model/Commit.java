
package aiss.PIntegracion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    @Column(name = "title")
    @NotEmpty(message = "Commit title is required")
    private String title;

    @JsonProperty("message")
    @Column(name = "message")
    @NotEmpty(message = "Commit message is required")
    private String message;

    @JsonProperty("author_name")
    @Column(name = "authorName")
    @NotEmpty(message = "Author name is required")
    private String authorName;

    @JsonProperty("author_email")
    @Column(name = "authorEmail")
    @NotEmpty(message = "Author email is required")
    private String authorEmail;

    @JsonProperty("authored_date")
    @Column(name = "authoredDate")
    @NotEmpty(message = "Authored date is required")
    private String authoredDate;

    @JsonProperty("web_url")
    @Column(name = "webUrl")
    @NotEmpty(message = "Commit webUrl is required")
    private String webUrl;

    @JsonProperty("project")
    @ManyToOne
    private Project project;

    public Commit(String id, String title, String message, String authorName, String authorEmail, String authoredDate,
                  String webUrl, Project project) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authoredDate = authoredDate;
        this.webUrl = webUrl;
        this.project = null;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("author_name")
    public String getAuthorName() {
        return authorName;
    }

    @JsonProperty("author_name")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("author_email")
    public String getAuthorEmail() {
        return authorEmail;
    }

    @JsonProperty("author_email")
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    @JsonProperty("authored_date")
    public String getAuthoredDate() {
        return authoredDate;
    }

    @JsonProperty("authored_date")
    public void setAuthoredDate(String authoredDate) {
        this.authoredDate = authoredDate;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {

        return "Commit{" +
                "id = " + id +
                ", title = " + title +
                ", message = " + message +
                ", author_Name = " + authorName +
                ", author_eMail = " + authorEmail +
                ", authored_Date = " + authoredDate +
                ", webUrl = " + webUrl +
//                ", project = " + project +
                "} \n";
    }
}