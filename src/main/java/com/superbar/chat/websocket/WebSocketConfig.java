package com.superbar.chat.websocket;

import com.superbar.chat.websocket.handler.SuperBarChatHandler;
import com.superbar.chat.websocket.interceptor.ChatHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * <p>Application Name : WebSocketConfig </p>
 * <p>Application Description : WebSocket Config Class </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019-11-16
 * @Version : v1.0
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * WebSocket连接允许域
     */
    @Value("${origin}")
    private String origin;

    @Autowired
    private SuperBarChatHandler superBarChatHandler;

    @Autowired
    private ChatHandshakeInterceptor chatHandshakeInterceptor;

    /**
     * 注册WebSocket处理器
     * 配置处理器、拦截器、允许域、SockJs支持
     *
     * @param registry registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        // 设置允许域，当请求的RequestHeaders中的Origin不在允许范围内，禁止连接
        String[] allowedOrigins = {origin};

        registry.addHandler(superBarChatHandler, "/superBarChat", "/chat")
                .addInterceptors(chatHandshakeInterceptor)
                .setAllowedOrigins(allowedOrigins);

        // 当浏览器不支持WebSocket，使用SockJs支持
        /*
        registry.addHandler(chatHandler, "/sockjs-chatHandler")
                .addInterceptors(chatHandshakeInterceptor)
                .setAllowedOrigins(allowedOrigins)
                .withSockJS();
         */
    }

}
