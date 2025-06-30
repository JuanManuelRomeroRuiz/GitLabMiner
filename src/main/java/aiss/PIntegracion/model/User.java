
package aiss.PIntegracion.model;

import aiss.PIntegracion.model.Comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("issue_author")
    private List<Issue> author;
    @JsonProperty("comment")
    private List<Comment> comment;
    @JsonProperty("issue_assignee")
    private List<Issue> assignee;


    public User(Integer id, String username, String name, String avatarUrl, String webUrl) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.webUrl = webUrl;
        this.author = new ArrayList<Issue>();
        this.comment = new ArrayList<Comment>();
        this.assignee = new ArrayList<Issue>();
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @JsonProperty("author")
    public List<Issue> getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(List<Issue> author) {
        this.author = author;
    }

    @JsonProperty("comment")
    public List<Comment> getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @JsonProperty("assignee")
    public List<Issue> getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(List<Issue> assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {

        return "User{" +
                "id = " + id +
                ", username = " + username +
                ", name = " + name +
                ", avatarUrl = " + avatarUrl +
                ", webUrl = " + webUrl +
//                ", author = " + author +
//                ", comment = " + comment +
//                ", assignee = " + assignee +
                "} \n";
    }
}