package com.bugtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "issue", schema = "bug_tracker_java_db")
public class Issue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String issueTitle;
    private String issueDescription;

    @Transient
    private String assignerUsername;
    @Transient
    private String assigneeUsername;
    @Transient
    private String projectName;

    private Integer assignerUserId;
    private Integer assigneeUserId;
    private Integer projectId;

    private String status;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    public Issue(){
    }

    public Issue(Integer id, String issueTitle, String issueDescription, Integer assignerUserId, Integer assigneeUserId, Integer projectId, String status) {
        this.id = id;
        this.issueTitle = issueTitle;
        this.issueDescription = issueDescription;
        this.assignerUserId = assignerUserId;
        this.assigneeUserId = assigneeUserId;
        this.projectId = projectId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getAssignerUsername() {
        return assignerUsername;
    }

    public void setAssignerUsername(String assignerUsername) {
        this.assignerUsername = assignerUsername;
    }

    public String getAssigneeUsername() {
        return assigneeUsername;
    }

    public void setAssigneeUsername(String assigneeUsername) {
        this.assigneeUsername = assigneeUsername;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getAssignerUserId() {
        return assignerUserId;
    }

    public void setAssignerUserId(Integer assignerUserId) {
        this.assignerUserId = assignerUserId;
    }

    public Integer getAssigneeUserId() {
        return assigneeUserId;
    }

    public void setAssigneeUserId(Integer assigneeUserId) {
        this.assigneeUserId = assigneeUserId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) && Objects.equals(issueTitle, issue.issueTitle) && Objects.equals(issueDescription, issue.issueDescription) && Objects.equals(assignerUsername, issue.assignerUsername) && Objects.equals(assigneeUsername, issue.assigneeUsername) && Objects.equals(projectName, issue.projectName) && Objects.equals(assignerUserId, issue.assignerUserId) && Objects.equals(assigneeUserId, issue.assigneeUserId) && Objects.equals(projectId, issue.projectId) && Objects.equals(status, issue.status) && Objects.equals(createdAt, issue.createdAt) && Objects.equals(lastUpdatedAt, issue.lastUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueTitle, issueDescription, assignerUsername, assigneeUsername, projectName, assignerUserId, assigneeUserId, projectId, status, createdAt, lastUpdatedAt);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", issueTitle='" + issueTitle + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", assignerUsername='" + assignerUsername + '\'' +
                ", assigneeUsername='" + assigneeUsername + '\'' +
                ", projectName='" + projectName + '\'' +
                ", assignerUserId=" + assignerUserId +
                ", assigneeUserId=" + assigneeUserId +
                ", projectId=" + projectId +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                '}';
    }
}
