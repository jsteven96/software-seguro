package com.learn.webhooks.github.services;

import com.learn.webhooks.github.entities.CommitEntity;
import com.learn.webhooks.github.models.WebhookResponse;
import com.learn.webhooks.github.repository.CommitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class WebhooksServiceImpl {
    @Autowired
    private CommitRepository repository;

    public WebhookResponse saveCommit(WebhookResponse request) {
        Timestamp timestamp = new Timestamp(Long.parseLong(request.getHeadCommit().getTimestamp()));

        CommitEntity entity = CommitEntity.builder()
                .id("1")
                .commitID(request.getHeadCommit().getId())
                .authorEmail(request.getPusher().getEmail())
                .commitMessage(request.getHeadCommit().getMessage())
                .authorName(request.getPusher().getName())
                .createdAt(new Date(timestamp.getTime()))
                .build();
        log.info("Objeto a guardar" + entity.toString());
        repository.save(entity);
        return request;
    }

    public List<CommitEntity> getCommitsByEmail(String email) {
        return repository.getCommitsByAuthorEmail(email);
    }
}
