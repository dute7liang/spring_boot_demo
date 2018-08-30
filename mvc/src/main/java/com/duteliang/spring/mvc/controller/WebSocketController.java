package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.websocket.first.FirstHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-20 16:24
 */
@Controller
@RequestMapping(value = "webSocketController")
public class WebSocketController extends BaseController {

	private final static String PAGE = "html/webSocket";

	@Autowired
	private FirstHandler firstHandler;

	@GetMapping(value = "page")
	public String page(){
		return PAGE;
	}


	/**
	 * 发消息给指定用户
	 */
	@PostMapping(value = "sendToUser")
	@ResponseBody
	public void sendToUser(String id,String message){
		firstHandler.sendMessageToUser(id, message);
	}

	/**
	 * 发消息给所有用户
	 */
	@PostMapping(value = "sendToAllUser")
	@ResponseBody
	public void sendToAllUser(String message){
		firstHandler.sendMessageToAllUsers(message);
	}

}
