package com.example.scutaru.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessaginHandlerController {

	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/alarms")
	public void send(@Payload String message) throws Exception {
		this.simpMessagingTemplate.convertAndSend("/topic/news", message);
	}
}
