package com.learn.webhooks.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WebhooksController {

    private static final Logger log = LoggerFactory.getLogger(WebhooksController.class);


    @PostMapping(path = "hello")
    public Map<String, Object> getWebHook(
            @RequestBody Map<String, Object> body
            ) {
        log.info("Receiving a request from a POST HTTP verb");
        log.info(body.toString());
        return body;
    }
}
