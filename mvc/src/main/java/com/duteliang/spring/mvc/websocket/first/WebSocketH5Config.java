package com.duteliang.spring.mvc.websocket.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description:  配置webSocket请求的路径和拦截器
 * @Auther: zl
 * @Date: 2018-8-20 14:07
 */
@Configuration
@EnableWebSocket
class WebSocketH5Config implements WebSocketConfigurer {

	@Autowired
	private WebSocketInterceptor webSocketInterceptor;

	@Autowired
	private FirstHandler firstHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(firstHandler,"/webSocket")
				.setAllowedOrigins("*") // 添加允许跨域访问
				.addInterceptors(webSocketInterceptor); // 配置拦截器
	}
}
