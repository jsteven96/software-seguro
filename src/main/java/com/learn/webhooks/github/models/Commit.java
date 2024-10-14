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
public class Commit {
    @JsonProperty("id")
    private String id;

    @JsonProperty("tree_id")
    private String treeId;

    @JsonProperty("distinct")
    private boolean distinct;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("url")
    private String url;

    @JsonProperty("author")
    private User author;

    @JsonProperty("committer")
    private User committer;

    @JsonProperty("added")
    private List<String> added;

    @JsonProperty("removed")
    private List<String> removed;

    @JsonProperty("modified")
    private List<String> modified;
}
