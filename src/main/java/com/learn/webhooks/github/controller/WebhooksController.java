package com.learn.webhooks.github.controller;

import com.learn.webhooks.github.entities.CommitEntity;
import com.learn.webhooks.github.models.WebhookResponse;
import com.learn.webhooks.github.services.WebhooksServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WebhooksController {

    private static final Logger log = LoggerFactory.getLogger(WebhooksController.class);

    @Autowired
    private WebhooksServiceImpl service;


    @PostMapping(path = "hello")
    public WebhookResponse processWebHook(
            @RequestBody WebhookResponse body
            ) {
        log.info("Receiving a request from a POST HTTP verb");
        log.info(body.toString());
        service.saveCommit(body);
        return body;
    }

    @GetMapping(path = "commits")
    public List<CommitEntity> getCommits(
            @RequestParam() String email
    ) {
        return service.getCommitsByEmail(email);
    }
}
