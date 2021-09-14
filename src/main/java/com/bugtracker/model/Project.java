package com.bugtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "project", schema = "bug_tracker_java_db")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String projectName;
    private String projectDescription;

    @Transient
    private String userName;

    private Integer userId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    @OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Issue> issues;


    public Project(){
    }

    public Project(Integer id, String projectName, String projectDescription, Integer userId) {
        this.id = id;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(projectName, project.projectName) && Objects.equals(projectDescription, project.projectDescription) && Objects.equals(userName, project.userName) && Objects.equals(userId, project.userId) && Objects.equals(createdAt, project.createdAt) && Objects.equals(lastUpdatedAt, project.lastUpdatedAt) && Objects.equals(issues, project.issues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, projectDescription, userName, userId, createdAt, lastUpdatedAt, issues);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", issues=" + issues +
                '}';
    }
}
