
package aiss.PIntegracion.model.Comment;

import java.util.List;

import aiss.PIntegracion.model.Issue;
import aiss.PIntegracion.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("id")
    private String id;
    @JsonProperty("notes")
    private List<Note> notes;
    @JsonProperty("author")
    private User author;
    @JsonProperty("issue")
    private Issue issue;

    public Comment(String id, List<Note> notes, User author, Issue issue) {
        this.id = id;
        this.notes = notes;
        this.author = null;
        this.issue = null;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("notes")
    public List<Note> getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @JsonProperty("author")
    public User getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(User author) {
        this.author = author;
    }

    @JsonProperty("issue")
    public Issue getIssue() {
        return issue;
    }

    @JsonProperty("issue")
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {

        return "Issue{" +
                "id = " + id +
                ", notes = " + notes +
                ", author = " + author +
                ", issue = " + issue +
                "} \n";
    }
}
