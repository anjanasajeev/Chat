package com.genesys.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesys.app.model.PSVChatMessage;
import com.genesys.app.repository.ChatRepository;
import com.genesys.app.service.PSVService;

@Service
public class PSVServiceImpl implements PSVService {

	@Autowired
	private ChatRepository repo;

	@Override
	public PSVChatMessage saveUser(PSVChatMessage user) {
		return repo.save(user);
	}

	@Override
	public List<String> getAllUsers() {
		return repo.togetAllUsers();
	}
	
	public String getUser(String emp_id) {
		return repo.getUser(emp_id);
	}

	public List<String> findChatConversation(String senderId, String recipientId) {
		return repo.findChatConversation(senderId, recipientId);
	}


}
