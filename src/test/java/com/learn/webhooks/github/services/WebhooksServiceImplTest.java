package com.learn.webhooks.github.services;

import com.learn.webhooks.github.entities.CommitEntity;
import com.learn.webhooks.github.models.Commit;
import com.learn.webhooks.github.models.RepositoryDTO;
import com.learn.webhooks.github.models.User;
import com.learn.webhooks.github.models.WebhookResponse;
import com.learn.webhooks.github.repository.CommitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@ExtendWith(MockitoExtension.class)
public class WebhooksServiceImplTest {
    @Mock
    CommitRepository repository;

    @InjectMocks
    WebhooksServiceImpl service;

    @Test
    public void shouldInsertAWebHookCommit() {
        Date date = new Date();
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(date);
        CommitEntity response = CommitEntity.builder()
                .id("1")
                .payload("")
                .commitID("1")
                .repoName("name")
                .createdAt(date)
                .authorName("authorName")
                .commitMessage("message")
                .authorEmail("email")
                .build();
        Mockito.when(repository.save(Mockito.any())).thenReturn(response);
        WebhookResponse webhookResponse = WebhookResponse.builder()
                .headCommit(Commit.builder()
                        .id("1")
                        .author(User.builder()
                                .email("email")
                                .name("authorName")
                                .build())
                        .timestamp(nowAsISO)
                        .message("message")
                        .build())
                .repository(RepositoryDTO.builder()
                        .name("name")
                        .build())
                .pusher(User.builder()
                        .name("authorName")
                        .email("email")
                        .build()).build();
        WebhookResponse result = service.saveCommit(webhookResponse);
        Assertions.assertNotNull(result);
    }
}
