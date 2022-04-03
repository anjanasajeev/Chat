package com.genesys.app.service;

import java.util.List;
import java.util.Optional;

import com.genesys.app.model.PSVChatMessage;


public interface PSVService {
	
	PSVChatMessage saveUser(PSVChatMessage user);
	
	List<String> getAllUsers();
	
	String getUser(String emp_id);
	
	List<String> findChatConversation(String senderId, String recipientId);
	
}
