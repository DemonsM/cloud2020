package com.ink.controller;

import com.ink.entity.Greeting;
import com.ink.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GreetingController {
    @Resource
    private SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(500); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @GetMapping("/ws/send/toAll")
    public void send() {
        sendingOperations.convertAndSend("/topic/toAll",
                new Greeting("Hello, " + HtmlUtils.htmlEscape("it`s my message") + "!"));
    }

    @PostMapping("/ws/send/toUser")
    public void send(@RequestBody List<String> userList) {
        for (String username : userList) {
            sendingOperations.convertAndSend("/topic/" + username,
                    new Greeting("Hello, " + HtmlUtils.htmlEscape("it`s my message") + "!"));
        }
    }
}
