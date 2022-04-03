package com.genesys.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesys.app.model.PSVChatMessage;
import com.genesys.app.repository.ChatRepository;
import com.genesys.app.service.PSVService;

@RestController
@RequestMapping("/genesys/users")
public class PSVController {

	@Autowired
	private PSVService psvService;
	
	//To get the Employee Name based on the ID
	@GetMapping("{id}")
	public String getUser(@PathVariable("id") String emp_id) {
		return psvService.getUser(emp_id);	
	}
	
	//To get all the users that has used the Chat Application
	@GetMapping("/all")
	public List<String> getAllUsers(){
		return psvService.getAllUsers();		
	}
		
	//To get the chat conversation between two users
	@GetMapping("{sender_id}/{receiver_id}")
	public List<String> findChatCoversationBetweenTwoUsers(@PathVariable("sender_id")String sender_empid, @PathVariable("receiver_id")String reciever_empid){
		return psvService.findChatConversation(sender_empid, reciever_empid);		
	}
	
	
		

}
