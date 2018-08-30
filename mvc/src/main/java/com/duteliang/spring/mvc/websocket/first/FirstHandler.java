package com.duteliang.spring.mvc.websocket.first;

import com.alibaba.fastjson.JSONObject;
import com.duteliang.spring.mvc.constanst.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-20 15:05
 */
@Service
@Slf4j
//@EnableWebSocket("webSocket)
public class FirstHandler implements WebSocketHandler {

//	private static List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<WebSocketSession>());

	/**
	 * key： 用户id
	 * WebSocketSession : 该用户id对应的socket通信
	 */
	private static ConcurrentHashMap<String,WebSocketSession> sessionMap= new ConcurrentHashMap<>();

	// 新增webSocket连接后的回调方法
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("成功建立连接！");
		Map<String, Object> attributes = session.getAttributes();
		Object userId = attributes.get(Constants.WEB_SOCKET_USERID);
		if (userId != null && StringUtils.isNotEmpty(userId.toString())) {
			sessionMap.put(userId.toString(), session);
			session.sendMessage(new TextMessage("成功建立socket连接"));
			System.out.println(userId);
			System.out.println(session);
		}
		System.out.println("当前在线人数："+sessionMap.size());
	}

	// 接收socket消息（暂缓）
	@Override
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
		Object payload = webSocketMessage.getPayload();
		JSONObject jsonobject = JSONObject.parseObject(payload.toString());
		System.out.println(jsonobject.get("id"));
		String userId = (String) webSocketSession.getAttributes().get(Constants.WEB_SOCKET_USERID);
		System.out.println(jsonobject.get("message")+":来自"+userId+"的消息");
		this.sendMessageToUser(userId,"服务器收到了，hello!");
	}


	/**
	 * 发送信息给指定用户
	 * @param clientId
	 * @param message
	 * @return
	 */
	public boolean sendMessageToUser(String clientId, String message) {
		if (sessionMap.get(clientId) == null) return false;
		WebSocketSession session = sessionMap.get(clientId);
		if (session == null || !session.isOpen()) return false;
		try {
			TextMessage textMessage = new TextMessage(message);
			session.sendMessage(textMessage);
		} catch (IOException e) {
			log.error("webSocket消息发送失败！",e);
			return false;
		}
		return true;
	}

	/**
	 * 广播信息
	 * @param message
	 * @return
	 */
	public boolean sendMessageToAllUsers(String message) {
		boolean allSendSuccess = true;
		WebSocketSession session;
		TextMessage textMessage = new TextMessage(message);
		for (Map.Entry<String, WebSocketSession> entry : sessionMap.entrySet()) {
			try {
				session = entry.getValue();
				if (session != null && session.isOpen()) {
					session.sendMessage(textMessage);
				}
			} catch (IOException e) {
				e.printStackTrace();
				allSendSuccess = false;
			}
		}
		return  allSendSuccess;
	}

	// socket连接出错时的回调方法
	@Override
	public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		System.out.println("连接出错");
		sessionMap.remove(getClientId(session));

	}

	// 关闭连接后的回调方法
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("连接已关闭：" + closeStatus);
		sessionMap.remove(getClientId(session));
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}


	/**
	 * 获取用户标识
	 * @param session
	 * @return
	 */
	private Integer getClientId(WebSocketSession session) {
		try {
			Object userId = session.getAttributes().get(Constants.WEB_SOCKET_USERID);
			if(userId != null){
				return NumberUtils.createInteger(userId.toString());
			}
		} catch (Exception e) {
			System.out.println("Do not handle exceptions");
		}
		return null;
	}
}


