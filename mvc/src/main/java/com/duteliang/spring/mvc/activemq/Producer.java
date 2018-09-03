package com.duteliang.spring.mvc.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description: 客户端，发送消息
 * @Auther: zl
 * @Date: 2018-9-3 14:00
 */
@Service
public class Producer {


	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	/**
	 * 发送下拍
	 * @param queueName
	 * @param message
	 */
	public void sendMessage(String queueName, Object message){
		jmsMessagingTemplate.convertAndSend(queueName, message);
	}

}

