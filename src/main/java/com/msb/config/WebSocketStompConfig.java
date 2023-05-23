package com.msb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-23 09:05
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    // 注册stomp协议的节点，指定客户端连接时需要指定的url
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp-server")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    // 配置消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 指定消息代理，客户端可订阅
        registry.enableSimpleBroker("/server-send-single", "/server-send-multi", "/server-send");
        // 服务端使用sendToUser向客户端推送
        registry.setUserDestinationPrefix("/server-send-single"); // 该前缀必须在消息代理里面
    }
}
