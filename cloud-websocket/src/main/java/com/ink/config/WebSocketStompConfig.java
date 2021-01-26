package com.ink.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author MT
 * @date 2021/1/19 9:35
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;
    @Value("${spring.rabbitmq.host}")
    private String relayHost;
    // @Value("spring.rabbitmq.port")
    // private Integer relayPort;
    @Value("${spring.rabbitmq.username}")
    private String userLogin;
    @Value("${spring.rabbitmq.password}")
    private String password;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/spring-boot-websocket").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //这里使用的是内存模式，生产环境可以使用rabbitmq或者其他mq。
        //这里注册两个，主要是目的是将广播和队列分开。
        //registry.enableStompBrokerRelay().setRelayHost().setRelayPort() 其他方式
        //registry.enableSimpleBroker("/topic", "/queue");
        registry.enableStompBrokerRelay("/topic", "/queue")
                .setVirtualHost(virtualHost)
                .setRelayHost(relayHost)
                //.setRelayPort(relayPort)
                .setClientLogin(userLogin)
                .setClientPasscode(password);
        //客户端名称前缀
        registry.setApplicationDestinationPrefixes("/app");
        //用户名称前
        registry.setUserDestinationPrefix("/user");
    }
}
