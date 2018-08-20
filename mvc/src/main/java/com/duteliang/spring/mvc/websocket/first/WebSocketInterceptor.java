package com.duteliang.spring.mvc.websocket.first;

import com.duteliang.spring.mvc.constanst.Constants;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description: webSocket的拦截器,会拦截试图用webSocket连接的消息
 * @Auther: zl
 * @Date: 2018-8-20 15:02
 */
@Component
public class WebSocketInterceptor implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
								   WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
		System.out.println("Hello world");
		if (request instanceof ServletServerHttpRequest) {
			String ID = request.getURI().toString().split("ID=")[1];
			System.out.println("当前session的ID="+ID);
			ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
			HttpSession session = serverHttpRequest.getServletRequest().getSession();
			map.put(Constants.SESSION_ID_KEY, session.getId());
			map.put("WEBSOCKET_USERID",ID);
		}
		return true;

	}

	@Override
	public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
		System.out.println("进来webSocket的afterHandshake拦截器！");
	}
}
