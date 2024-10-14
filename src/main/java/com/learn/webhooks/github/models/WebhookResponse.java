package com.learn.webhooks.github.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebhookResponse {
    @JsonProperty("ref")
    private String ref;

    @JsonProperty("before")
    private String before;

    @JsonProperty("after")
    private String after;

    @JsonProperty("repository")
    private RepositoryDTO repository;

    @JsonProperty("pusher")
    private User pusher;

    @JsonProperty("sender")
    private User sender;

    @JsonProperty("created")
    private boolean created;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonProperty("forced")
    private boolean forced;

    @JsonProperty("compare")
    private String compare;

    @JsonProperty("commits")
    private List<Commit> commits;

    @JsonProperty("head_commit")
    private Commit headCommit;
}
