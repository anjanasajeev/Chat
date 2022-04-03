package com.genesys.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.genesys.app.model.PSVChatMessage;
import com.genesys.app.repository.ChatRepository;

@Controller
public class PSVChatController {

	@Autowired
	ChatRepository chatRepo;
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public PSVChatMessage register(@Payload PSVChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public PSVChatMessage sendMessage(@Payload PSVChatMessage chatMessage) {
		chatRepo.save(chatMessage);
		return chatMessage;
	}

}
