
package aiss.PIntegracion.model;

import java.util.ArrayList;
import java.util.List;

import aiss.PIntegracion.model.Comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @Id
    @JsonProperty("iid")
    private Integer iid;

    @JsonProperty("title")
    @Column(name = "title")
    @NotEmpty(message = "Issue title is required")
    private String title;

    @JsonProperty("description")
    @Column(name = "description")
    @NotEmpty(message = "Issue description is required")
    private String description;

    @JsonProperty("state")
    @Column(name = "state")
    @NotEmpty(message = "Issue state is required")
    private String state;

    @JsonProperty("created_at")
    @Column(name = "createdAt")
    @NotEmpty(message = "CreatedAt date is required")
    private String createdAt;

    @JsonProperty("updated_at")
    @Column(name = "updatedAt")
    @NotEmpty(message = "UpdatedAt date is required")
    private String updatedAt;

    @JsonProperty("closed_at")
    @Column(name = "closedAt")
    @NotEmpty(message = "ClosedAt date is required")
    private String closedAt;

    @JsonProperty("labels")
    @Column(name = "labels")
    @NotEmpty(message = "Issue labels are required")
    private List<String> labels;

    @JsonProperty("upvotes")
    @Column(name = "upvotes")
    @NotEmpty(message = "Issue upvotes are required")
    private Integer upvotes;

    @JsonProperty("downvotes")
    @Column(name = "downvotes")
    @NotEmpty(message = "Issue downvotes are required")
    private Integer downvotes;

    @JsonProperty("comment")
    @OneToMany
    private List<Comment> comment;

    @JsonProperty("author")
    @ManyToOne
    private User author;

    @JsonProperty("assignee")
    @ManyToOne
    private User assignee;

    @JsonProperty("project")
    @ManyToOne
    private Project projectId;



    public Issue(Integer id, Integer iid,String title, String description, String state, String createdAt, String updatedAt, String closedAt,
                 List<String> labels, Integer upvotes, Integer downvotes, List<Comment> comment, User author, User assignee, Integer projectId) {
        this.id = id;
        this.iid = iid;
        this.title = title;
        this.description = description;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.labels = labels;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.comment = new ArrayList<Comment>();
        this.author = null;
        this.assignee = null;
        this.projectId = null;
    }

    @JsonProperty("iid")
    public Integer getIid(){ return iid; }

    @JsonProperty("iid")
    public void setIid(Integer iid){ this.iid = iid; }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }


    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("closed_at")
    public String getClosedAt() {
        return closedAt;
    }

    @JsonProperty("closed_at")
    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
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

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("labels")
    public List<String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @JsonProperty("upvotes")
    public Integer getUpvotes() {
        return upvotes;
    }

    @JsonProperty("upvotes")
    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    @JsonProperty("downvotes")
    public Integer getDownvotes() {
        return downvotes;
    }

    @JsonProperty("downvotes")
    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    @JsonProperty("comment")
    public List<Comment> getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @JsonProperty("author")
    public User getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(User author) {
        this.author = author;
    }

    @JsonProperty("assignee")
    public User getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @JsonProperty("project")
    public Project getProjectId() {
        return projectId;
    }

    @JsonProperty("project")
    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {

        return "Issue{" +
                "id = " + id +
                "iid = " + iid +
                ", title = " + title +
                ", description = " + description +
                ", state = " + state +
                ", created_At = " + createdAt +
                ", updated_At = " + updatedAt +
                ", closed_At = " + closedAt +
                ", labels = " + labels +
                ", upvotes = " + upvotes +
                ", downvotes = " + downvotes +
//                ", comment = " + comment +
//                ", author = " + author +
//                ", assignee = " + assignee +
//                ", projectId = " + projectId +
                "} \n";
    }
}
