package com.learn.webhooks.github.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COMMIT")
public class CommitEntity {
    @Id
    private String id;
    @Column(name = "repo_name")
    private String repoName;
    @Column(name = "commit_id")
    private String commitID;
    @Column(name = "commit_message")
    private String commitMessage;
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "author_email")
    private String authorEmail;
    @Column(name = "payload")
    private String payload;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
}
