package com.duteliang.spring.mvc.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * @Description: 消费者
 * @Auther: zl
 * @Date: 2018-9-3 09:58
 */
@Service
@Slf4j
public class Consumer {

	@Value("${duteliang.mvc.consumer-test:555}")
	private String test;

	@JmsListener(destination = "${duteliang.mvc.consumer-test}")
	public void receiveQueue(Message message){
		log.info("收到消息为："+message);
		if(message instanceof MapMessage){
			log.info("MapMessage 消息");
		}else if(message instanceof ObjectMessage){
			log.info("ObjectMessage 消息");
		}

	}

	public void syso(){
		log.info(test);
	}
}
