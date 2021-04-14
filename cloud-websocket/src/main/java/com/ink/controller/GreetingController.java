package com.ink.controller;

import com.ink.entity.Greeting;
import com.ink.entity.HelloMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "首页模块")
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

    @ApiOperation(value = "向全体发送")
    @GetMapping("/ws/send/toAll")
    public void send() {
        sendingOperations.convertAndSend("/topic/toAll",
                new Greeting("Hello, " + HtmlUtils.htmlEscape("it`s my message") + "!"));
    }

    @ApiOperation(value = "向个人发送")
    @PostMapping("/ws/send/toUser")
    public void send(@RequestBody List<String> userList) {
        for (String username : userList) {
            sendingOperations.convertAndSend("/topic/" + username,
                    new Greeting("Hello, " + HtmlUtils.htmlEscape("it`s my message") + "!"));
        }
    }


    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

}
