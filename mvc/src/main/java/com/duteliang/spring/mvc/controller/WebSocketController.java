package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.websocket.first.FirstHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-20 16:24
 */
@RestController("webSocketController")
public class WebSocketController extends BaseController {

	@Autowired
	private FirstHandler firstHandler;

	/**
	 * 发消息给指定用户
	 */
	@PostMapping(value = "sendToUser")
	public void sendToUser(String id,String message){
		firstHandler.sendMessageToUser(id, message);
	}

	/**
	 * 发消息给所有用户
	 */
	@PostMapping(value = "sendToAllUser")
	public void sendToAllUser(String message){
		firstHandler.sendMessageToAllUsers(message);
	}

}
